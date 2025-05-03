# 🛡️ AI-Driven Forensic Blockchain Analysis Tool - Backend (Spring Boot)


This is the back-end REST API for the AI-Driven Forensic Blockchain Analysis Tool, designed to aid in tracking, analyzing, and detecting fraudulent cryptocurrency transactions. Built with Spring Boot, it leverages JWT Authentication and provides secure access to forensic data.

## 🚀 Features

🔐 JWT-based Authentication (Login & Register)

🧾 User Role Management

📊 Forensic Transaction Data APIs

🔍 Incident and Risk Analysis Modules

🛡️ Secure Endpoints with Role-based Access Control

🧠 Integration-ready for AI-powered Prediction Services

## 🛠️ Tech Stack

Java 17+

Spring Boot

Spring Security

JWT (JSON Web Tokens)

Spring Data JPA

PostgreSQL (recommended DB)

Maven

## 📁 Project Structure (Back-End)


src/

├── main/java/com/yourcompany/cryptoapi/

│   ├── auth/                 # Login/Register/JWT Authentication

│   ├── config/               # Security configuration (JWT filters)

│   ├── controller/           # REST controllers

│   ├── model/                # JPA entities

│   ├── repository/           # Spring Data JPA Repositories

│   ├── service/              # Business logic, token generation

│   └── CryptoApiApplication.java

└── main/resources/

└── application.properties

## 🔑 Authentication API

| Endpoint               | Method | Description           |
|------------------------|--------|-----------------------|
| `/api/auth/register`   | POST   | Register new user     |
| `/api/auth/login`      | POST   | Authenticate and get JWT token |

**Example `POST /api/auth/register` Payload:**
```json
{
  "username": "john_doe",
  "password": "securePassword123"
}
```

**Example JWT Response:**

```json
{
"token": "eyJhbGciOiJIUzI1NiIsIn..."
}
```

## 🔒 Security
Stateless JWT Authentication

Passwords hashed with BCryptPasswordEncoder

Secured all routes except /api/auth/**

## ▶️ Running the Application
Clone the repo:

```
git clone https://github.com/yourusername/forensic-blockchain-backend.git
cd forensic-blockchain-backend
Set up your application.properties:
```

properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/crypto_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
jwt.secret=your_custom_jwt_secret
```

Build and run:

```
mvn spring-boot:run
```

## 🧪 Testing Endpoints

Use Postman or curl to interact with the API.

## 📌 Future Improvements

Add AI-Powered Risk Prediction endpoint (/api/predict)

Integrate forensic transaction tracking services

Implement admin and analyst dashboards

Add Swagger/OpenAPI documentation

## 🧑‍💻 Contributors

Amal Jawahdou (amal.jawahdou@uni.li)

## 📄 License
This project is under the MIT License.