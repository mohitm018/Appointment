package com.appointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appointment.entity.Doctor;
import com.appointment.exception.ResourceNotFoundException;
import com.appointment.repository.DoctorRepository;

@Service
public class DoctorService {
	private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // CREATE
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // READ ALL
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // READ BY ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Doctor not found with id: " + id));
    }

    // UPDATE
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Doctor not found with id: " + id));

        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setEmail(doctorDetails.getEmail());

        return doctorRepository.save(doctor);
    }

    // DELETE
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Doctor not found with id: " + id));

        doctorRepository.delete(doctor);
    }

}
