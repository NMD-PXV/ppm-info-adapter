package com.dxc.ppm.infoadapter.repository;

import com.dxc.ppm.infoadapter.model.PersonalInfoEntity;
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

    @Query("select p from PersonalInfoEntity p where p.patientId in :ids")
    List<PersonalInfoEntity> findMultiByPatientIds(@Param("ids") List<String> ids);
}
