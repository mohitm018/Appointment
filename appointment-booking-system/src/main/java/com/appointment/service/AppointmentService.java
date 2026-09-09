package com.appointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appointment.entity.Appointment;
import com.appointment.entity.AppointmentStatus;
import com.appointment.entity.Doctor;
import com.appointment.entity.Patient;
import com.appointment.exception.ResourceNotFoundException;
import com.appointment.repository.AppointmentRepository;
import com.appointment.repository.DoctorRepository;
import com.appointment.repository.PatientRepository;
import com.appointment.exception.AppointmentAlreadyBookedException;
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository,
            DoctorRepository doctorRepository) {

        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    // CREATE APPOINTMENT
    public Appointment createAppointment(Appointment appointment) {

        Long patientId = appointment.getPatient().getId();
        Long doctorId = appointment.getDoctor().getId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found with id: " + patientId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with id: " + doctorId));

        boolean alreadyBooked =
        	    appointmentRepository
        	        .existsByDoctorIdAndAppointmentDateAndAppointmentTimeAndStatusNot(
        	            doctorId,
        	            appointment.getAppointmentDate(),
        	            appointment.getAppointmentTime(),
        	            AppointmentStatus.CANCELLED
        	        );

        if (alreadyBooked) {
            throw new AppointmentAlreadyBookedException(
                    "Doctor is already booked for this date and time"
            );
        
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    // GET ALL APPOINTMENTS
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // GET APPOINTMENT BY ID
    public Appointment getAppointmentById(Long id) {

        return appointmentRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Appointment not found with id: " + id)
                );
    }

    // UPDATE APPOINTMENT
    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Appointment not found with id: " + id));

        Long doctorId = appointment.getDoctor().getId();

        // Check if date/time/status is changed
        boolean dateChanged =
                !appointment.getAppointmentDate()
                        .equals(appointmentDetails.getAppointmentDate());

        boolean timeChanged =
                !appointment.getAppointmentTime()
                        .equals(appointmentDetails.getAppointmentTime());

        boolean statusChanged =
                appointment.getStatus() != appointmentDetails.getStatus();

        // Check doctor availability when booking details change
        if (dateChanged || timeChanged || statusChanged) {

            boolean alreadyBooked =
                    appointmentRepository
                            .existsByDoctorIdAndAppointmentDateAndAppointmentTimeAndStatusNotAndIdNot(
                                    doctorId,
                                    appointmentDetails.getAppointmentDate(),
                                    appointmentDetails.getAppointmentTime(),
                                    AppointmentStatus.CANCELLED,
                                    id
                            );

            // CANCELLED appointment should not be blocked
            if (alreadyBooked
                    && appointmentDetails.getStatus() != AppointmentStatus.CANCELLED) {

                throw new AppointmentAlreadyBookedException(
                        "Doctor is already booked for this date and time"
                );
            }
        }

        appointment.setAppointmentDate(
                appointmentDetails.getAppointmentDate());

        appointment.setAppointmentTime(
                appointmentDetails.getAppointmentTime());

        appointment.setStatus(
                appointmentDetails.getStatus());

        return appointmentRepository.save(appointment);
    }

    // DELETE APPOINTMENT
    public void deleteAppointment(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Appointment not found with id: " + id)
                );

        appointmentRepository.delete(appointment);
    }
}
