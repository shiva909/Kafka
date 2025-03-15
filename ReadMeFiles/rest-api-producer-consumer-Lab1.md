# Lab 1: Sending Bulk Messages to Kafka and Testing Performance

## Objective:
Sending bulk messages to Kafka continuously as a Producer and testing the speed, tolerance, and accuracy as a Consumer.

## Description:
In this lab, we will send messages to the Kafka server using REST APIs with specified topic names. We will test the bulk messages to ensure they are received by our Spring Boot application, and measure how fast the messages are processed.

## Prerequisites:
1. Download and install **Kafka** (which includes **Zookeeper**). You can download Kafka from the following link:  
   [Kafka Downloads](https://kafka.apache.org/downloads)
   > **Note:** Download the version that corresponds to **Scala 2.12** or later.

## Steps:

### 1. Set Up a Spring Boot Project
- Download a Spring Boot project from [start.spring.io](https://start.spring.io) with the following dependencies:
    - **Spring Web**
    - **Spring for Apache Kafka**

### 2. Producer Setup
- Use the `KafkaTemplate` class in Spring Boot to send messages using the `send()` method.
  ```java
  kafkaTemplate.send("topicName", "message");
  ```
- This will send the message to the Kafka server.

### 3. Consumer Setup
- Listen to Kafka messages using the `@KafkaListener` annotation in Spring Boot.
  ```java
  @KafkaListener(topics = "topicName", groupId = "groupName")
  ```
  > **Note:** The `groupId` is crucial for load balancing when dealing with large-scale message consumption.

- You can print the received messages within the Kafka listener for verification.

### 4. Running Kafka and Zookeeper
- Navigate to the Kafka installation directory and run the following commands to start **Zookeeper** and **Kafka**:

#### a) To Run Zookeeper:
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
This command starts Zookeeper using the properties specified in the `zookeeper.properties` file located in the `config` folder.

#### b) To Run Kafka:
```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
This command starts the Kafka server using the properties specified in the `server.properties` file located in the `config` folder.

---

### 5. YML Configuration
Make sure to configure your application by adding the following settings in your `application.yml` file:
```yaml
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
```
This configuration ensures that your Spring Boot application is properly connected to the Kafka server for message production.

### Note:
Make sure to update your `.yml` configuration files to ensure proper connection between your Spring Boot application and Kafka. This includes setting up the Kafka server, topic names, and group IDs as per your application requirements.

With this setup, you will be able to send bulk messages to Kafka, test the performance of message transmission, and verify the messages using a Spring Boot consumer.

