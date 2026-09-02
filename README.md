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
|---|---|---|
| GET | `/` | Checks whether the application is running |
| GET | `/employees` | Returns the list of employees |

## Run the Application Locally

### Build the application

```bash
./mvnw clean package

Run the Jar
java -jar target/employee-app-0.0.1-SNAPSHOT.jar
## The application runs on
http://localhost:8080

## Test the API
curl http://localhost:8080/
curl http://localhost:8080/employees

### Build docker image

## Build the Maven Application
./mvnw clean package

## Build the Docker image
docker build -t employee-app:1.0 .

## Run with Docker
docker run -p 8080:8080 employee-app:1.0

## Then access:

http://localhost:8080/employees

### Deploy to Kubernetes

## Start Minikube
minikube start --driver=docker

## Use Minikube's Docker environment
eval $(minikube docker-env)

## Build the image inside Minikube
docker build -t employee-app:1.0 .

## Deploy the application
kubectl apply -f deployment.yaml

## Create the Kubernetes Service
kubectl apply -f service.yaml

## Check the Deployment
kubectl get deployments

## Check the Pods
kubectl get pods

## Check the Service
kubectl get services

## Access the application
minikube service employee-service --url

## Test the Employee API
curl $(minikube service employee-service --url)/employees

Kubernetes Architecture

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

 
## Kubernetes Features Demonostrated
Declarative Kubernetes configuration using YAML
Kubernetes Deployment
Kubernetes Service
Multiple replicas
Pod self-healing
Containerized Spring Boot application
Docker image deployment
Minikube local Kubernetes environment


Project Structure

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

## Author

Sowmya
