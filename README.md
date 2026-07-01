# 📄 Smart Resume Analyzer

A secure Resume Analyzer application built using **Java, Spring Boot, Spring Security, JWT, Hibernate, MySQL, Docker, and Render**. The application enables users to securely upload resumes, analyze skills, receive resume scores, and get personalized job recommendations through RESTful APIs.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🔑 JWT-based Authentication & Authorization
- 🔒 BCrypt Password Encryption
- 📄 Resume Upload
- 🧠 Resume Analysis
- 🎯 Skill Extraction
- 📊 Resume Scoring
- 💼 Job Recommendation APIs
- 📈 Resume Insights
- 🗄️ MySQL Database Integration
- 🐳 Docker Containerization
- ☁️ Cloud Deployment on Render
- 📮 RESTful API Design
- 🏗️ Layered Architecture

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Security
- Spring Security
- JWT Authentication
- BCrypt

### Database
- MySQL (Aiven Cloud)

### Tools
- Docker
- Maven
- Git
- GitHub
- Postman
- Eclipse

### Deployment
- Docker Hub
- Render

---

## 🏗️ Architecture

```text
                  Client
                     │
             HTTP REST APIs
                     │
            Spring Boot Controller
                     │
               Service Layer
                     │
      Resume Analysis & Business Logic
                     │
            JPA Repository Layer
                     │
              MySQL Database

Security:
Spring Security + JWT

Deployment:
Docker → Docker Hub → Render
```

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── config
├── security
├── exception
└── util
```

---

## 📮 API Endpoints

### 🏠 Health Check

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/health` | Checks whether the application is running successfully |

**Response**

```text
smart resume analyzer is running successfully!
```

---

### 📄 Resume APIs

#### Upload Resume

| Method | Endpoint |
|--------|----------|
| POST | `/resume/upload` |

**Headers**

```text
Authorization: Bearer <JWT_TOKEN>
```

**Form Data**

```text
file : Resume.pdf
```

**Returns**

- Resume Score
- Extracted Skills
- Matching Job Roles

---

#### Get All Uploaded Resumes

| Method | Endpoint |
|--------|----------|
| GET | `/resume/all` |

Returns all resumes stored in the database.

---

### 💼 Recommendation API

#### Get Best Matching Job

| Method | Endpoint |
|--------|----------|
| POST | `/recommend/best` |

**Headers**

```text
Authorization: Bearer <JWT_TOKEN>
```

**Form Data**

```text
file : Resume.pdf
```

**Returns**

```text
Best Matching Job
Matching Score
Required Skills
```

---

### 📊 Resume Insight API

#### Analyze Skills

| Method | Endpoint |
|--------|----------|
| POST | `/insight` |

**Request Body**

```json
[
  "Java",
  "Spring Boot",
  "Hibernate",
  "Docker"
]
```

**Returns**

- Resume Insights
- Skill Analysis
- Suggestions for Improvement

---

## 🧩 Security Features

- JWT Authentication
- Role-based Authorization
- BCrypt Password Encryption
- Protected REST APIs
- Stateless Session Management

---

## 💻 Installation

### Clone Repository

```bash
git clone https://github.com/ShilpaReddy2006/smart-resume-analyzer.git
```

### Move to Project

```bash
cd smart-resume-analyzer
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

---

## 🐳 Docker

### Build Image

```bash
docker build -t smart-resume-analyzer .
```

### Run Container

```bash
docker run -p 8099:8099 smart-resume-analyzer
```

---

## ☁️ Live Demo

https://smart-resume-analyzer-latest-4.onrender.com/ping

---

## 📁 GitHub Repository

https://github.com/ShilpaReddy2006/smart-resume-analyzer

---

## 📸 Screenshots

Add screenshots of:

- Login API
- Register API
- Resume Upload API
- Resume Analysis Response
- Resume Insight API
- Best Job Recommendation API
- Docker Container
- Render Deployment
- Postman Collection

---

## 🧪 API Testing

All REST APIs were tested using **Postman**.

### Tested APIs

- ✅ GET `/health`
- ✅ POST `/resume/upload`
- ✅ GET `/resume/all`
- ✅ POST `/recommend/best`
- ✅ POST `/insight`

### Authentication

Protected endpoints use **JWT Bearer Token Authentication**.

**Example Header**

```text
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

### Test Workflow

1. Authenticate and obtain JWT token.
2. Add the JWT token in the Authorization header.
3. Upload a resume using multipart/form-data.
4. Analyze the uploaded resume.
5. Retrieve the best matching job recommendation.
6. View stored resumes.
7. Analyze resume skills using the Insight API.

---

## ⚡ Challenges

- Implementing JWT authentication using Spring Security.
- Configuring secure cloud database connectivity with Aiven MySQL.
- Deploying Dockerized Spring Boot applications on Render.
- Managing environment variables during deployment.
- Designing scalable layered architecture.
- Processing multipart file uploads securely.

---

## 📚 Lessons Learned

- Spring Security & JWT Authentication
- Docker Containerization
- Cloud Deployment
- REST API Design
- Layered Architecture
- Hibernate & JPA
- Production Configuration
- Secure Backend Development
- Environment Variable Management

---

## 🚀 Future Enhancements

- AI-powered Resume Analysis
- ATS Compatibility Score
- PDF Report Generation
- Email Notifications
- Resume Version History
- Admin Dashboard
- Skill Gap Analysis
- Interview Question Recommendations

---

## 👨‍💻 Author

**Yerravalla Shilpa Reddy**

**GitHub**  
https://github.com/ShilpaReddy2006

**LinkedIn**  
https://www.linkedin.com/in/shilpa-reddy-0266272a5

**Email**  
shilpareddy24871@gmail.com

---

⭐ If you found this project useful, consider giving it a star on GitHub!
