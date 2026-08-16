# Spring Boot JWT Authorization Authentication

A sample Spring Boot application demonstrating JWT-based authentication/authorization together with
Spring Security, Spring Data JPA, and PostgreSQL.

## Tech Stack

- Java 25
- Spring Boot 4.1.0
- Spring Security 7
- Spring Data JPA / Hibernate
- PostgreSQL
- [jjwt](https://github.com/jwtk/jjwt) 0.13.0 for JWT creation/parsing
- Lombok
- Maven

## Prerequisites

- JDK 25
- PostgreSQL running locally (or reachable) with a database named `jwt`

Create the database before running the app or its tests:

```bash
psql -U postgres -c "CREATE DATABASE jwt;"
```

Connection settings are configured in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/jwt
    username: postgres
    password: hendi34
```

Adjust these to match your local PostgreSQL setup.

## Building

```bash
./mvnw clean package
```

## Running

```bash
./mvnw spring-boot:run
```

or, after packaging:

```bash
java -jar target/jwt-authorization-authentication-0.0.1-SNAPSHOT.jar
```

The application starts on port `8081`.

## Testing

```bash
./mvnw test
```

The test suite boots the full Spring context, so a reachable PostgreSQL instance (see Prerequisites) is required.

## API

| Method | Endpoint        | Auth required | Description                     |
|--------|-----------------|---------------|----------------------------------|
| POST   | `/api/register` | No            | Register a new user              |
| GET    | `/api/users`    | Yes (Basic)   | List all registered users        |

Example:

```bash
curl -X POST http://localhost:8081/api/register \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Hendi","lastName":"Santika","email":"hendi@example.com","username":"hendi","password":"secret123","activated":true}'

curl -u hendi:secret123 http://localhost:8081/api/users
```

## Continuous Integration

GitHub Actions builds the project against JDK 25 on every push and pull request to `main`, using a
PostgreSQL service container so the Spring context can load during tests. See
`.github/workflows/maven.yml`.
