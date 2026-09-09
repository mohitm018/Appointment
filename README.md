# 🏥 Appointment Booking System

A **Spring Boot REST API** based Appointment Booking System that allows patients to book appointments with doctors, manage appointment details, and track appointment status.

This project demonstrates backend development using **Java, Spring Boot, Spring Data JPA, REST APIs, and MySQL**.

---

## 🚀 Features

*  Doctor management
*  Patient management
*  Book appointments
*  Manage appointment date and time
*  Update appointment status
*  Cancel appointments
*  Find appointment by ID
*  Find patient by ID
*  Find doctor by ID
*  Database persistence using MySQL
*  Exception handling for invalid IDs and missing records
*  Entity relationships using JPA

---

## 🛠️ Technologies Used

| Technology      | Purpose                     |
| --------------- | --------------------------- |
| Java            | Backend programming         |
| Spring Boot     | Application framework       |
| Spring Data JPA | Database interaction        |
| Hibernate       | ORM                         |
| MySQL           | Database                    |
| Maven           | Dependency management       |
| REST API        | Client-server communication |
| Postman         | API testing                 |
| Git & GitHub    | Version control             |

---

## 📂 Project Structure

```text
appointment-booking-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.appointmentbooking/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── PatientController.java
│   │   │       │   ├── DoctorController.java
│   │   │       │   └── AppointmentController.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   ├── PatientService.java
│   │   │       │   ├── DoctorService.java
│   │   │       │   └── AppointmentService.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── PatientRepository.java
│   │   │       │   ├── DoctorRepository.java
│   │   │       │   └── AppointmentRepository.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   ├── Patient.java
│   │   │       │   ├── Doctor.java
│   │   │       │   └── Appointment.java
│   │   │       │
│   │   │       └── exception/
│   │   │           └── ResourceNotFoundException.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

## 🏗️ Architecture

The application follows a layered architecture:

```
Client / Postman
       ↓
   Controller
       ↓
     Service
       ↓
   Repository
       ↓
      JPA
       ↓
     MySQL
```
---

# 🧪 Testing

The REST APIs can be tested using **Postman**.

Recommended testing flow:

```text
1. Create Doctor
       ↓
2. Create Patient
       ↓
3. Create Appointment
       ↓
4. Get Appointment
       ↓
5. Update Appointment Status
       ↓
6. Cancel Appointment
```

---

# 🔄 Example Workflow

```text
Patient
   │
   │ Books Appointment
   ↓
Appointment
   │
   ├── Appointment Date
   ├── Appointment Time
   ├── Patient
   ├── Doctor
   └── Status
          │
          ├── BOOKED
          ├── CONFIRMED
          ├── COMPLETED
          └── CANCELLED
```

---

# 🔐 Error Responses

The API returns appropriate HTTP status codes.

| Status Code | Meaning               |
| ----------- | --------------------- |
| 200         | Request successful    |
| 201         | Resource created      |
| 400         | Bad request           |
| 404         | Resource not found    |
| 500         | Internal server error |

---

# 🎯 Learning Objectives

This project was developed to practice:

* Java backend development
* Spring Boot
* REST API development
* CRUD operations
* Spring Data JPA
* Hibernate
* MySQL database integration
* Entity relationships
* Exception handling
* HTTP status codes
* Postman API testing
* Layered architecture

---

# 🔮 Future Enhancements

Possible improvements include:

* 🔐 Spring Security & JWT authentication
* 👨‍⚕️ Doctor availability management
* 📧 Email appointment notifications
* 🔎 Search doctors by specialization
* 📆 Doctor calendar
* 🚫 Prevent double booking
* 👤 Role-based access for Admin, Doctor and Patient


---

# 👨‍💻 Author

**Mohit Mahendra Patil**

Java Backend Developer

📍 Pune, Maharashtra, India

📧 [mohitpatil012@gmail.com](mailto:mohitpatil012@gmail.com)

---

## ⭐ If you found this project useful

Give the repository a ⭐ on GitHub.
