package com.dxc.ppm.nurseadapter.ulti;

import com.dxc.ppm.nurseadapter.api.model.PersonalInfo;
import com.dxc.ppm.nurseadapter.model.PersonalInfoEntity;
import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;

public class PersonalInfoUlti {
    public static void info2Entity(PersonalInfoEntity entity, PersonalInfo info){
        entity.setDob(info.getDob().toDate());
        entity.setFullName(info.getFullName());
        entity.setSex(info.getSex());
        entity.setPob(info.getPob());
    }
}
