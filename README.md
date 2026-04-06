# Zorvyn-TE3CU2FW-
financeApp

# 💰 Finance Management Application (Spring Boot + JWT)

## 📌 Project Overview

The **Finance Management Application** is a secure REST API built using **Spring Boot** that allows users to manage financial records such as income and expenses. The application includes **JWT-based authentication**, **role-based access control**, and **MySQL database integration**.

---

## 🚀 Features

### 🔐 Authentication & Security

* User Registration & Login
* JWT Token-based Authentication
* Role-based Authorization (ADMIN / USER)
* Password Encryption using BCrypt
* Token Expiry Handling
* Logout with Token Blacklisting

---

### 💼 Financial Management

* Add Financial Records (Income / Expense)
* View Records
* Categorize Transactions
* Track Date-wise Data
* Notes support

---

### 📊 Dashboard

* Total Income Calculation
* Total Expense Calculation
* Summary by Record Type

---

### 🗄️ Database

* MySQL integration using Spring Data JPA
* Entity Relationships (User ↔ FinancialRecord)

---

## 🛠️ Tech Stack

| Layer        | Technology            |
| ------------ | --------------------- |
| Backend      | Spring Boot 4         |
| Security     | Spring Security + JWT |
| Database     | MySQL                 |
| ORM          | Hibernate (JPA)       |
| Build Tool   | Maven                 |
| Java Version | Java 24               |

---

## 📂 Project Structure

```
com.java.app
│
├── controller        → REST APIs
├── service           → Business logic
├── repository        → Database operations
├── entity            → JPA entities
├── security          → JWT & Security config
├── config            → App configurations
└── FinanceApplication.java
```

---

## 🔐 JWT Authentication Flow

1. User logs in with email & password
2. Server validates credentials
3. JWT token is generated
4. Token is sent in response
5. Client sends token in headers:

   ```
   Authorization: Bearer <token>
   ```
6. Server validates token for every request

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

* Java 24
* Maven
* MySQL

---

### 🔧 1. Clone Project

```bash
git clone https://github.com/your-username/finance-app.git
cd finance-app
```

---

### 🔧 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/financeapplication
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 🔧 3. Run Application

```bash
mvn clean install
mvn spring-boot:run
```

App will start at:

```
http://localhost:8080
```

---

## 📡 API Endpoints (Postman Testing)

---

### 🔐 Auth APIs

#### ✅ Register

```
POST /api/auth/register
```

**Body:**

```json
{
  "name": "Sagar",
  "email": "sagar@gmail.com",
  "password": "123456",
  "role": "USER"
}
```

---

#### ✅ Login

```
POST /api/auth/login
```

**Response:**

```json
{
  "token": "JWT_TOKEN_HERE"
}
```

---

### 💰 Financial APIs

#### ➕ Add Record

```
POST /api/records
```

Header:

```
Authorization: Bearer <token>
```

Body:

```json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-06",
  "notes": "Monthly salary"
}
```

---

#### 📄 Get All Records

```
GET /api/records
```

---

#### 📊 Dashboard Summary

```
GET /api/dashboard
```

---

## 🔑 Security Implementation

* Password stored using **BCrypt hashing**
* JWT token signed using **HS256 algorithm**
* Secret key ≥ 256 bits (mandatory)
* Custom filter for token validation
* Role-based access using Spring Security

---

## ⚠️ Common Issues & Fixes

### ❌ WeakKeyException

👉 Fix: Use strong key (≥ 32 characters)

---

### ❌ javax.xml.bind error

👉 Fix: Remove old `jjwt:0.6.0` dependency

---

### ❌ Repository method error

👉 Fix: Use `@Query` instead of derived method

---

## 📌 Future Enhancements

* Swagger API Documentation
* Excel/CSV Import
* Graph Visualization (Charts)
* Email Notifications
* Mobile App Integration

---

## 👨‍💻 Author

**Sagar Patil**

* Java Developer
* Spring Boot Enthusiast

---

## ⭐ Conclusion

This project demonstrates:

* Real-world backend architecture
* Secure authentication using JWT
* Clean layered structure (Controller → Service → Repository)
* Production-ready best practices

