package com.dxc.ppm.nurseadapter.delegate;

import com.dxc.ppm.nurseadapter.api.V1ApiDelegate;
import com.dxc.ppm.nurseadapter.api.model.PersonalInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1ApiDelegateImpl implements V1ApiDelegate {
    @Override
    public ResponseEntity<PersonalInfo> readPatientInfoById(String patientId) {
        return null;
    }

    @Override
    public ResponseEntity<String> upsert(PersonalInfo info) {
        return null;
    }

    @Override
    public ResponseEntity<String> upsertMultiPatientInfos(List<PersonalInfo> infos) {
        return null;
    }
}
