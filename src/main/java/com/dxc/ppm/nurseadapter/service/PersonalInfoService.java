package com.dxc.ppm.nurseadapter.service;

import com.dxc.ppm.nurseadapter.api.model.PersonalInfo;
import com.dxc.ppm.nurseadapter.exception.PersonalInfoException;
import com.dxc.ppm.nurseadapter.model.PersonalInfoEntity;
import com.dxc.ppm.nurseadapter.repository.PersonalInfoRepository;
import com.dxc.ppm.nurseadapter.ulti.PersonalInfoUlti;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.dxc.ppm.nurseadapter.common.PersonalInfoStorageError.*;

@Service
public class PersonalInfoService {
    @Autowired
    private PersonalInfoRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonalInfoService.class);

    //TODO validate
    @Transactional
    public String create(PersonalInfo personalInfo) {
        String patientId = UUID.randomUUID().toString();
        PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();
        PersonalInfoUlti.info2Entity(personalInfoEntity, personalInfo);
        personalInfoEntity.setPatientId(patientId);
        personalInfoEntity.setDeleted(false);
        repository.saveAndFlush(personalInfoEntity);
        return patientId;
    }

    @Transactional
    public String upsert(PersonalInfo personalInfo) {
        String patientId = personalInfo.getPatientId();
        PersonalInfoEntity personalInfoEntity = repository.findByPatientIdAndDeleted(patientId, false);
        if (personalInfoEntity == null)
            return create(personalInfo);

        PersonalInfoUlti.info2Entity(personalInfoEntity, personalInfo);
        repository.saveAndFlush(personalInfoEntity);
        return patientId;
    }

    public PersonalInfo readPatientInfoById(String patientId) {
        PersonalInfoEntity entity = repository.findByPatientIdAndDeleted(patientId, false);
        if (entity == null)
            throw new PersonalInfoException(PATIENT_NOT_FOUND, patientId);
        return PersonalInfoUlti.entity2Info(entity);
    }

    public List<PersonalInfo> searchPatientsByName(String patientName) {
        if(patientName == null)
            return repository.findAll()
                    .stream()
                    .map(PersonalInfoUlti::entity2Info)
                    .collect(Collectors.toList());
        return repository.searchByName(patientName)
                .stream()
                .map(PersonalInfoUlti::entity2Info)
                .collect(Collectors.toList());
    }

    public List<PersonalInfo> readMultiPatientInfoById(List<String> ids){
        return repository.findMultiByPatientIds(ids).
                stream().
                map(PersonalInfoUlti::entity2Info).
                collect(Collectors.toList());
    }
}
