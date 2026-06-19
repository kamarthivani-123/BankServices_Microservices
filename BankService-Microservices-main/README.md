# Bank Microservices Project

## Overview

This project demonstrates a Banking Microservices Architecture using Spring Boot.

Features:

- JWT Authentication
- Account Management
- Money Transfer
- H2 Database
- Kafka Event Publishing
- Saga Pattern
- Redis Caching
- Spring Boot Actuator Monitoring

---

## Microservices

### Auth Service

Port: 8080

Responsibilities:

- User Login
- JWT Token Generation
- Authentication

Endpoints:

POST /auth/login

---

### Account Service

Port: 8081

Responsibilities:

- Create Account
- Get Account Details
- Balance Lookup

Endpoints:

POST /accounts

GET /accounts/{id}

---

### Transaction Service

Port: 8083

Responsibilities:

- Transfer Money
- Transaction History
- Kafka Event Publishing

Endpoints:

POST /transactions/transfer

---

## Database

Database: H2

Console:

http://localhost:8081/h2-console

---

## Kafka Events

Published Events:

- TRANSFER_INITIATED
- AMOUNT_DEBITED
- AMOUNT_CREDITED
- TRANSFER_FAILED
- TRANSFER_COMPENSATED

Topic:

bank-transactions

---

## Saga Pattern

Transfer Flow:

TRANSFER_INITIATED
        ↓
AMOUNT_DEBITED
        ↓
AMOUNT_CREDITED

Failure Flow:

TRANSFER_FAILED
        ↓
TRANSFER_COMPENSATED

---

## Redis Cache

Used For:

- Account Details
- Balance Lookup

Annotation:

@Cacheable(value = "accounts", key = "#id")

---

## Monitoring

Spring Boot Actuator

Endpoints:

http://localhost:8080/actuator/health

http://localhost:8081/actuator/health

http://localhost:8083/actuator/health

---

## Technologies

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- Apache Kafka
- Redis
- Maven

---

## Author

Vani kamarthi
