````markdown
# Centralized Communication Hub with Kafka

This project aims to create a centralized communication hub using Kafka, Spring Boot microservices, and Docker. The primary objective is to build a scalable and reliable messaging platform that can handle various services, such as Order Service, User Service, and Notification Service, efficiently.

## Table of Contents

1. [Introduction](#introduction)
2. [Architecture](#architecture)
3. [Microservices](#microservices)
   - [Order Service](#order-service)
   - [User Service](#user-service)
   - [Notification Service](#notification-service)
4. [Technology Stack](#technology-stack)
5. [Setting Up the Project](#setting-up-the-project)
   - [Prerequisites](#prerequisites)
   - [Configuration](#configuration)
   - [Building and Running](#building-and-running)
6. [Kafka Configuration](#kafka-configuration)
7. [API Endpoints](#api-endpoints)
   - [Order Service](#order-service-api)
   - [User Service](#user-service-api)
   - [Notification Service](#notification-service-api)
8. [Logging](#logging)
9. [Conclusion](#conclusion)

## Introduction

The goal of this project is to demonstrate the integration of Apache Kafka with multiple Spring Boot microservices to establish a centralized communication hub. This setup ensures that services can produce and consume messages efficiently, providing a robust messaging backbone for any distributed system.

## Architecture

The architecture consists of multiple microservices communicating via Kafka topics. Each microservice is responsible for specific functionality and can produce or consume messages as needed.

![Architecture Diagram](./architecture-diagram.png)

## Microservices

### Order Service

- **Purpose:** Manages orders, including creation, retrieval, and deletion.
- **Kafka Interaction:** Produces messages to the `order_topic` and `log_topic`.

### User Service

- **Purpose:** Manages user information.
- **Kafka Interaction:** Can produce and consume messages related to user activities.

### Notification Service

- **Purpose:** Sends notifications based on various triggers.
- **Kafka Interaction:** Consumes messages from the `order_topic` and sends notifications accordingly.

## Technology Stack

- **Spring Boot:** Framework for building microservices.
- **Apache Kafka:** Messaging platform for producing and consuming messages.
- **Docker:** Containerization platform.
- **PostgreSQL:** Relational database for persistent storage.
- **MapStruct:** Java bean mappings.
- **Lombok:** Reduces boilerplate code for model objects.

## Setting Up the Project

### Prerequisites

- **Docker:** Ensure Docker and Docker Compose are installed.
- **Java 21:** Make sure Java 21 is installed.
- **Maven:** Ensure Maven is installed.

### Configuration

- **Docker Compose:** The `docker-compose.yml` file sets up Kafka, Zookeeper, PostgreSQL, and the microservices.
- **Application Properties:** Each service has its own `application.properties` for configurations.

### Building and Running

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/sogutemir/SpringBootKafkaExample.git
   cd SpringBootKafkaExample
   ```
````

2. **Build the Services:**

   ```bash
   mvn clean install
   ```

3. **Start the Docker Containers:**

   ```bash
   docker-compose up --build
   ```

4. **Access the Services:**
   - Order Service: `http://localhost:8083`
   - User Service: `http://localhost:8081`
   - Notification Service: `http://localhost:8084`

## Kafka Configuration

- **Kafka Topics:** The topics used in this project are `order_topic` and `log_topic`.
- **Producer Configuration:** Defined in `KafkaProducerConfig.java`.
- **Consumer Configuration:** Defined in `KafkaConsumerConfig.java`.

## Logging

Each service logs important events to the `log_topic` on Kafka. This setup allows for centralized logging and monitoring.

## Conclusion

This project showcases the integration of Kafka with multiple Spring Boot microservices to create a centralized communication hub. By following the setup instructions, you can run the project locally and observe how the microservices interact via Kafka topics.

---

This README provides a comprehensive overview of the project, its architecture, and the steps to set it up. For detailed information on each microservice and additional configurations, refer to the individual service documentation.

## GitHub Links

- **GitHub Profile:** [sogutemir](https://github.com/sogutemir)
- **Repository:** [SpringBootKafkaExample](https://github.com/sogutemir/SpringBootKafkaExample)

```

```
