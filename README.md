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

#### Docker
* mvn clean install -DskipTests
* docker build -t star-tracker .
* Upload this image to the docker repository using Docker Desktop if you are signed in.