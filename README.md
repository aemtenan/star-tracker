# Star Tracker API

## Introduction
In this project we build a REST API to track stars in the sky.

### Tools Used:
* Environment: OpenJDK 21
* Framework: Spring Boot 3.1.5
* Database: PostgreSQL 16.1
* Technologies: RESTful API, JPA for Data Access Layer

### Instructions

#### Standalone
* Create a local database in PostgreSQL with name 'startracker' and password 'password'
* From the command prompt/terminal, call 'mvn spring-boot:run'
* If you want to use a different database config, please modify 'application.properties'.

#### Docker and Docker Compose
* Build the JAR: 'mvn clean install -DskipTests'
* Build the Docker image for star-tracker service: 'docker build -t star-tracker .'
* Run Docker Compose to start both the star-tracker API and PostgreSQL db - 'docker compose up'

## API Reference

| Action        | Method | Path                                 | Body                                                                                                                      | HTTP response |
|---------------|--------|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------|---------------|
| Add a star    | POST   | http://localhost:8080/api/v2/stars   | {"name": "Proxima Centauri","constellation": "Centaurus", "distanceInLightYears": "4.2465","temperatureInKelvin": "2992"} | 201           |
| Get all stars | GET    | http://localhost:8080/api/v2/stars   |                                                                                                                           |               |
| Get a star    | GET    | http://localhost:8080/api/v2/stars/1 |                                                                                                                           | 200           |
| Update a star | PUT    | http://localhost:8080/api/v2/stars/1 | {"name": "Proxima Centauri","constellation": "Centaurus", "distanceInLightYears": "4.2465","temperatureInKelvin": "3000"} | 200           |
| Delete a star | DELETE | http://localhost:8080/api/v2/stars/1 |                                                                                                                           | 204           |

