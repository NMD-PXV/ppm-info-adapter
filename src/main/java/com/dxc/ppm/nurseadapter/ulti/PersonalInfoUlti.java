package com.dxc.ppm.nurseadapter.ulti;

import com.dxc.ppm.nurseadapter.api.model.PersonalInfo;
import com.dxc.ppm.nurseadapter.model.PersonalInfoEntity;
import org.joda.time.LocalDate;

public class PersonalInfoUlti {
    public static void info2Entity(PersonalInfoEntity entity, PersonalInfo info){
        entity.setDob(info.getDob().toDate());
        entity.setFullName(info.getFullName());
        entity.setSex(info.getSex());
        entity.setAddress(info.getAddress());
        entity.setPob(info.getPob());
        entity.setPatientId(info.getPatientId());
    }

    public static PersonalInfo entity2Info(PersonalInfoEntity entity){
        PersonalInfo info = new PersonalInfo();
        info.setAddress(entity.getAddress());
        info.setDob(LocalDate.fromDateFields(entity.getDob()));
        info.setFullName(entity.getFullName());
        info.setPatientId(entity.getPatientId());
        info.setSex(entity.getSex());
        info.setPob(entity.getPob());
        return info;
    }
}
