package com.dxc.ppm.nurseadapter.repository;

import com.dxc.ppm.nurseadapter.model.PersonalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfoEntity, Long> {
}
