# 🏥 Appointment Booking System

A **Spring Boot REST API** based Appointment Booking System that allows patients to book appointments with doctors, manage appointment details, and track appointment status.

This project demonstrates backend development using **Java, Spring Boot, Spring Data JPA, REST APIs, and MySQL**.

---

## 🚀 Features

* 👨‍⚕️ Doctor management
* 🧑‍🤝‍🧑 Patient management
* 📅 Book appointments
* 🕐 Manage appointment date and time
* ✅ Update appointment status
* ❌ Cancel appointments
* 🔍 Find appointment by ID
* 🔍 Find patient by ID
* 🔍 Find doctor by ID
* 🗄️ Database persistence using MySQL
* ⚠️ Exception handling for invalid IDs and missing records
* 🔗 Entity relationships using JPA

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

```text
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

### Controller Layer

Handles HTTP requests and responses.

### Service Layer

Contains the application's business logic.

### Repository Layer

Communicates with the database using Spring Data JPA.

### Entity Layer

Represents database tables using JPA entities.

---

## 🗃️ Main Entities

### 👤 Patient

Example:

```json
{
    "id": 1,
    "name": "Rahul Sharma",
    "age": 30,
    "email": "rahul@gmail.com",
    "phone": "9876543210"
}
```

### 👨‍⚕️ Doctor

Example:

```json
{
    "id": 1,
    "name": "Dr. Amit Sharma"
}
```

### 📅 Appointment

An appointment connects a patient with a doctor.

Example:

```json
{
    "appointmentDate": "2026-09-10",
    "appointmentTime": "10:30:00",
    "status": "CANCELLED",
    "patient": {
        "id": 1,
        "name": "Rahul Sharma",
        "age": 30,
        "email": "rahul@gmail.com",
        "phone": "9876543210"
    },
    "doctor": {
        "id": 1,
        "name": "Dr. Amit Sharma"
    }
}
```

---

# 🔗 API Endpoints

## 👤 Patient APIs

### Create Patient

```http
POST /patients
```

Request:

```json
{
    "name": "Rahul Sharma",
    "age": 30,
    "email": "rahul@gmail.com",
    "phone": "9876543210"
}
```

### Get Patient

```http
GET /patients/{id}
```

Example:

```http
GET /patients/1
```

### Delete Patient

```http
DELETE /patients/{id}
```

---

# 👨‍⚕️ Doctor APIs

### Create Doctor

```http
POST /doctors
```

Request:

```json
{
    "name": "Dr. Amit Sharma"
}
```

### Get Doctor

```http
GET /doctors/{id}
```

### Delete Doctor

```http
DELETE /doctors/{id}
```

---

# 📅 Appointment APIs

### Create Appointment

```http
POST /appointments
```

Example request:

```json
{
    "appointmentDate": "2026-09-10",
    "appointmentTime": "10:30:00",
    "status": "BOOKED",
    "patientId": 1,
    "doctorId": 1
}
```

### Get Appointment

```http
GET /appointments/{id}
```

Example:

```http
GET /appointments/1
```

### Update Appointment Status

```http
PUT /appointments/{id}/status
```

Example:

```json
{
    "status": "CANCELLED"
}
```

### Delete Appointment

```http
DELETE /appointments/{id}
```

---

# 📌 Appointment Status

The appointment can have different statuses:

```text
BOOKED
CONFIRMED
COMPLETED
CANCELLED
```

---

# ⚠️ Exception Handling

The application handles cases where a requested resource does not exist.

For example:

```http
GET /patients/999
```

Response:

```json
{
    "timestamp": "2026-09-08T22:22:47.4690291",
    "status": 404,
    "message": "Patient not found with id: 999"
}
```

This prevents the application from returning unclear server errors when a patient, doctor, or appointment cannot be found.

---

# 🗄️ Database Configuration

Configure MySQL in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/appointment_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Replace `YOUR_PASSWORD` with your local MySQL password.

---

# ▶️ How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/your-username/appointment-booking-system.git
```

### 2. Open the project

Open the project in:

* IntelliJ IDEA
* Eclipse
* Spring Tool Suite
* VS Code

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE appointment_db;
```

Update your MySQL username and password in:

```text
application.properties
```

### 4. Build the project

Using Maven:

```bash
mvn clean install
```

### 5. Run the application

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class directly.

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

*  Spring Security & JWT authentication
*  Doctor availability management
*  Email appointment notifications
*  Search doctors by specialization
*  Doctor calendar
* Prevent double booking
*  Role-based access for Admin, Doctor and Patient
*  Admin dashboard
*  Unit and integration testing

---

# 👨‍💻 Author

**Mohit Mahendra Patil**

Java Backend Developer

📍 Pune, Maharashtra, India

📧 [mohitpatil012@gmail.com](mailto:mohitpatil012@gmail.com)

---

## ⭐ If you found this project useful

Give the repository a ⭐ on GitHub.
