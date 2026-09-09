package com.appointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appointment.entity.Patient;
import com.appointment.repository.PatientRepository;
import com.appointment.exception.ResourceNotFoundException;

@Service
public class PatientService {
	private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    // CREATE
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // READ ALL
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // READ BY ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException(
        			    "Patient not found with id: " + id
        			));
    }

    // UPDATE
    public Patient updatePatient(Long id, Patient patientDetails) {

        Patient patient = patientRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException(
        			    "Patient not found with id: " + id
        			));

        patient.setName(patientDetails.getName());
        patient.setEmail(patientDetails.getEmail());
        patient.setPhone(patientDetails.getPhone());
        patient.setAge(patientDetails.getAge());

        return patientRepository.save(patient);
    }

    // DELETE
    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException(
        			    "Patient not found with id: " + id
        			));
        patientRepository.delete(patient);
    }


}
