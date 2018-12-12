package com.dxc.ppm.infoadapter.delegate;

import com.dxc.ppm.infoadapter.api.V1ApiDelegate;
import com.dxc.ppm.infoadapter.api.model.PersonalInfo;
import com.dxc.ppm.infoadapter.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1ApiDelegateImpl implements V1ApiDelegate {
    @Autowired
    private PersonalInfoService service;


    @Override
    public ResponseEntity<List<PersonalInfo>> readMultiPatientInfoByPatientIds(List<String> ids) {
        return ResponseEntity.ok(service.readMultiPatientInfoById(ids));
    }

    @Override
    public ResponseEntity<PersonalInfo> readPatientInfoById(String patientId) {
        return ResponseEntity.ok(service.readPatientInfoById(patientId));
    }

    @Override
    public ResponseEntity<List<PersonalInfo>> searchPatientsByName(String patientName) {
        return ResponseEntity.ok(service.searchPatientsByName(patientName));
    }


    @Override
    public ResponseEntity<String> upsert(PersonalInfo info) {
        return ResponseEntity.ok(service.upsert(info));
    }

}