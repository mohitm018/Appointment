package com.appointment.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.entity.Appointment;
import com.appointment.entity.AppointmentStatus;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTimeAndStatusNot(
            Long doctorId,
            LocalDate appointmentDate,
            LocalTime appointmentTime,
            AppointmentStatus status
    );

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTimeAndStatusNotAndIdNot(
            Long doctorId,
            LocalDate appointmentDate,
            LocalTime appointmentTime,
            AppointmentStatus status,
            Long id
    );
}