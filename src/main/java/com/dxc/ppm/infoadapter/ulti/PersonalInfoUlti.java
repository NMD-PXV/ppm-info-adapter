package com.dxc.ppm.infoadapter.ulti;

import com.dxc.ppm.infoadapter.api.model.PersonalInfo;
import com.dxc.ppm.infoadapter.model.PersonalInfoEntity;
import org.joda.time.LocalDate;

public class PersonalInfoUlti {
    public static void info2Entity(PersonalInfoEntity entity, PersonalInfo info){
        entity.setDob(info.getDob().toDate());
        entity.setFullname(info.getFullname());
        entity.setSex(info.getSex());
        entity.setAddress(info.getAddress());
        entity.setPob(info.getPob());
        entity.setPatientId(info.getPatientId());
    }

    public static PersonalInfo entity2Info(PersonalInfoEntity entity){
        PersonalInfo info = new PersonalInfo();
        info.setPatientId(entity.getPatientId());
        info.setAddress(entity.getAddress());
        info.setDob(LocalDate.fromDateFields(entity.getDob()));
        info.setFullname(entity.getFullname());
        info.setPatientId(entity.getPatientId());
        info.setSex(entity.getSex());
        info.setPob(entity.getPob());
        return info;
    }
}
