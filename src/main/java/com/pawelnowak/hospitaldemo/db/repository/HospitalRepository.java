package com.pawelnowak.hospitaldemo.db.repository;

import com.pawelnowak.hospitaldemo.db.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {
    List<Hospital> findAllByName(String licenseNumber);
}
