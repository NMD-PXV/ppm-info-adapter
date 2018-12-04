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

import java.util.UUID;

import static com.dxc.ppm.nurseadapter.common.PersonalInfoStorageError.*;

@Service
public class PersonalInfoService {
    @Autowired
    private PersonalInfoRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonalInfoService.class);

    @Transactional
    public String create(PersonalInfo personalInfo) {
        PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();
        PersonalInfoUlti.info2Entity(personalInfoEntity, personalInfo);
        personalInfoEntity.setPatientId(personalInfo.getPatientId());
        personalInfoEntity.setDeleted(false);
        logger.info("----------------------------------------------------------------------");
        repository.saveAndFlush(personalInfoEntity);
        return personalInfo.getPatientId();
    }

    @Transactional
    public String upsert(PersonalInfo personalInfo) {
        String patientId = personalInfo.getPatientId();
        PersonalInfoEntity personalInfoEntity = repository.findByPatientIdAndDeleted(patientId, false);
        if (personalInfoEntity == null)
            return create(personalInfo);

        PersonalInfoUlti.info2Entity(personalInfoEntity, personalInfo);
        personalInfoEntity.setPatientId(patientId);
        repository.saveAndFlush(personalInfoEntity);
        return patientId;
    }
}
