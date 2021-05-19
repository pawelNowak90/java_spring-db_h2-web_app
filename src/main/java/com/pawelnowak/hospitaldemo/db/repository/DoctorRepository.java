package com.pawelnowak.hospitaldemo.db.repository;

import com.pawelnowak.hospitaldemo.db.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    List<Doctor> findAllByLicenseNumber(String licenseNumber);

    Doctor findByName(String name);
}
