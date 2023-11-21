# Star Tracker API

## Introduction
In this project we build a REST API to track stars in the sky.

### Tools Used:
* Environment: OpenJDK 21
* Framework: Spring Boot 3.1.5
* Database: PostgreSQL 16
* Technologies: RESTful API, JPA for Data Access Layer

### Instructions

#### Standalone
* Create a local database in PostgreSQL with name 'startracker' and password 'password'
* From the command prompt/terminal, call 'mvn spring-boot:run'
* If you want to use a different database config, please modify 'application.properties'.

#### Docker
* Build the JAR: mvn clean install -DskipTests
* Build the Docker image: docker build -t star-tracker .
* Upload this image to the docker repository.
* Please modify 'Dockerfile' if you would like to use a different JDK image.
