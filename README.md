
# Fitness Tracker Full Stack App

A full-stack fitness tracking application built with Java 21, Spring Boot, Spring Security, JWT, MySQL, and React with Vite.

## 🚀 Technologies Used

- **Backend:** Java 21, Spring Boot, Spring Security
- **Authentication:** JWT, BCrypt password hashing
- **Database:** MySQL, Spring Data JPA
- **Frontend:** React, Vite
- **API Documentation:** Swagger/OpenAPI
- **Build Tool:** Maven

## ✨ Features

- User registration and login
- Secure password hashing
- JWT-based authentication
- Spring Security integration
- User-specific workout CRUD API
- Workout dashboard
- MySQL database persistence
- Swagger/OpenAPI documentation
- Responsive React user interface
- Dockerfile starter

## 📋 Prerequisites

Install the following before running the application:

- JDK 21
- Maven
- MySQL Server
- Node.js and npm

## ⚙️ Database Configuration

Configure your MySQL credentials in `backend/src/main/resources/application.properties`.

Update the database username and password to match your local MySQL setup. Do not commit real passwords or secrets to GitHub.

## ▶️ Run the Backend

Open CMD in the project root and execute:

```bash
cd backend
mvn spring-boot:run
```

Backend URL: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html

## ▶️ Run the Frontend

Open another terminal in the project root and execute:

```bash
cd frontend
npm install
npm run dev
```

Frontend URL: http://localhost:5173

## 🔮 Future Improvements

- Fitness goals and progress tracking
- BMI and weight history
- Progress charts and analytics
- Refresh token support
- Admin dashboard
- Workout DTO mapping and pagination
- Integration testing
- Docker Compose setup

## 👨‍💻 Project

**Fitness Tracker Full Stack App**

Built with Java, Spring Boot, React, and MySQL.
