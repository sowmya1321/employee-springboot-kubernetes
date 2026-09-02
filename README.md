# Employee Spring Boot Kubernetes Application

A simple Spring Boot REST API for managing employee information and deploying the application using Docker and Kubernetes.

## Technologies Used

- Java 21
- Spring Boot
- Maven
- REST API
- Docker
- Kubernetes
- Minikube
- Git & GitHub

## Application Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Checks whether the application is running |
| GET | `/employees` | Returns the list of employees |

## Run the Application Locally

### Build the Application

```bash
./mvnw clean package
```

### Run the Jar

```bash
java -jar target/employee-app-0.0.1-SNAPSHOT.jar
```

### The Application Runs On

```bash
http://localhost:8080
```

### Test the API
```bash
curl http://localhost:8080/
curl http://localhost:8080/employees
```

## Build Docker Image

### Build the Maven Application
```bash
./mvnw clean package
```

### Build the Docker Image
```bash
docker build -t employee-app:1.0 .
```

### Run with Docker
```bash
docker run -p 8080:8080 employee-app:1.0
```

### Then Access
```bash
http://localhost:8080/employees
```

## Deploy to Kubernetes
### Start Minikube
```bash
minikube start --driver=docker
```

### Use Minikube's Docker Environment
```bash
eval $(minikube docker-env)
```

### Build the Image Inside Minikube
```bash
docker build -t employee-app:1.0 .
```

### Deploy the Application
```bash
kubectl apply -f deployment.yaml
```
### Create the Kubernetes Service
```bash
kubectl apply -f service.yaml
```

### Check the Deployment
```bash
kubectl get deployments
```

### Check the Pods
```bash
kubectl get pods
```

### Check the Service
```bash
kubectl get services
```

### Access the Application
```bash
minikube service employee-service --url
```

### Test the Employee API
```bash
curl $(minikube service employee-service --url)/employees
```

# Kubernetes Architecture
```bash
User
  |
  v
Kubernetes Service
  |
  +---------+
  |         |
  v         v
Pod 1     Pod 2
  |         |
  +---------+
       |
       v
Spring Boot Application
       |
       v
Employee REST API
```

# Kubernetes Features Demonstrated

- Declarative Kubernetes configuration using YAML-
- Kubernetes Deployment
- Kubernetes Service
- Multiple replicas
- Pod self-healing
- Containerized Spring Boot application
- Docker image deployment
- Minikube local Kubernetes environment

# Project Structure
```bash
employee-app/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/employeeapp/
│   │           ├── EmployeeAppApplication.java
│   │           ├── Employee.java
│   │           └── EmployeeController.java
│   └── test/
├── Dockerfile
├── deployment.yaml
├── service.yaml
├── pom.xml
├── mvnw
├── .gitignore
└── README.md
```
