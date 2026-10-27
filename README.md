# Fitness Tracker Full Stack App

Java 21 + Spring Boot + Spring Security + JWT + MySQL backend with a React/Vite frontend.

## Requirements
- JDK 21
- Maven
- MySQL
- Node.js/npm

## Database
The backend URL uses `createDatabaseIfNotExist=true`.
Default MySQL credentials in `application.properties` are:
- username: root
- password: root

Change them to match your MySQL installation.

## Run backend
```bash
cd backend
mvn spring-boot:run
```

Backend: http://localhost:8080

Swagger: http://localhost:8080/swagger-ui/index.html

## Run frontend
```bash
cd frontend
npm install
npm run dev
```

Frontend: http://localhost:5173

## Included
- User registration/login
- BCrypt password hashing
- JWT authentication
- Spring Security
- User-specific workout CRUD API
- Workout dashboard
- MySQL/JPA persistence
- Swagger/OpenAPI
- Responsive React UI
- Dockerfile starter

## Next portfolio upgrades
Add fitness goals, BMI/weight history, charts, refresh tokens, admin dashboard,
DTO mapping for workouts, pagination, integration tests and docker-compose.
