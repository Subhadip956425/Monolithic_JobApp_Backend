# Monolithic Job Application Backend

This repository contains the monolithic backend implementation for a Job Application Platform built using Spring Boot and PostgreSQL. It manages job postings, company data, and applicant reviews with REST APIs.

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger (for API documentation)

---

## 📂 Features

- Company CRUD operations
- Job Postings
- Applicant Reviews
- RESTful APIs for full backend functionality
- Exception Handling
- Validation

---

## 🧾 API Endpoints (Sample)

| Method | Endpoint                     | Description                |
|--------|------------------------------|----------------------------|
| GET    | `/companies`                 | Get all companies          |
| POST   | `/companies`                 | Create new company         |
| GET    | `/jobs`                      | Get all job listings       |
| POST   | `/jobs`                      | Post a new job             |
| DELETE | `/reviews/{reviewId}`        | Delete a specific review   |

> Full API Documentation is available via Swagger UI.

---

## ⚙️ Configuration

Update the `application.properties` file with your PostgreSQL configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobapp
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
