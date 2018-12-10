package com.dxc.ppm.nurseadapter.repository;

import com.dxc.ppm.nurseadapter.api.model.PersonalInfo;
import com.dxc.ppm.nurseadapter.model.PersonalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfoEntity, Long> {
    PersonalInfoEntity findByPatientIdAndDeleted(String patientId, boolean deleted);

    @Query("select p from PersonalInfoEntity p where p.fullname like CONCAT('%',:name,'%')")
    List<PersonalInfoEntity> searchByName(@Param("name") String name);
}
