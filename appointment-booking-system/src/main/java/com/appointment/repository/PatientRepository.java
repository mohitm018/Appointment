package com.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appointment.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
