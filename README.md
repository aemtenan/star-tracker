# Star Tracker API

## Introduction
In this project we build a containerized REST API using Docker and Kubernetes to track stars in the sky.

### Tools Used:
* Environment: OpenJDK 21
* Framework: Spring Boot 3.1.5
* Database: PostgreSQL 16.1
* Technologies: RESTful API, JPA for Data Access Layer
* Docker and Docker Compose
* Kubernetes

### Instructions

#### Standalone
* Create a local database in PostgreSQL with name 'startracker' and password 'password'
* From the command prompt/terminal, call 'mvn spring-boot:run'
* If you want to use a different database config, please modify 'application.properties'.

#### Docker and Docker Compose
* Build the JAR: 'mvn clean install -DskipTests'
* Build the Docker image for star-tracker service: 'docker build -t star-tracker .'
* Run Docker Compose to start both the star-tracker API and PostgreSQL db - 'docker compose up'

#### Kubernetes
Kubernetes config files for PostgreSQL are located in the folder: kubernetes-config-postgresql-db
* k8s-persistent-volume-db.yml: Defines the persistent volume storage in the cluster.
* k8s-persistent-volume-claim-db.yml: Defines the request for storage by a user. Contains information such as specific size and access modes to persistent volume resources.
* k8s-config-map-init-db.yml: Defines a ConfigMap to store database initialization configuration data.
* k8s-service-db.yml: Defines a Service to expose the PostgreSQL database as a network application.
* k8s-deployment-db.yml: Defines the deployment to manage the pods running the PostgreSQL database workload.
* Start local Kubernetes minikube by executing: 
* For each YAML file, execute - kubectl apply -f {file_name}.yml
* Verify the database pod is running by executing - kubectl get all
* Connect to the pod, login using user postgres, and connect to the 'startracker' database to view the schema:
  ![alt text](https://github.com/aemtenan/star-tracker/blob/main/src/main/resources/static/k8s-db-schema.png?raw=true)

Kubernetes config files for Spring Boot service are located in the folder: kubernetes-config-service
* k8s-service-startracker.yml: Defines a Service to expose the Spring Boot app as a network application.
* k8s-deployment-startracker.yml: Defines the deployment to manage the pods running the Spring Boot service workload.
* Change the application.properties to add following environmental variables:
    * spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
    * spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
    * spring.datasource.url=${SPRING_DATASOURCE_URL}
* Build the Docker image for star-tracker service: 'docker build -t {docker_username}/star-tracker .'
* Push the image to the hub
* Start minikube
* For each YAML file, execute - kubectl apply -f {file_name}.yml
* Perform port forwarding - kubectl port-forward service/star-tracker-service 7080:8080
* Verify the spring boot service pod is running by executing - kubectl get all
* Call the REST API to verify the service:
  ![alt text](https://github.com/aemtenan/star-tracker/blob/main/src/main/resources/static/postman-call.png?raw=true)


## API Reference

| Action        | Method | Path                                 | Body                                                                                                                      | HTTP response |
|---------------|--------|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------|---------------|
| Add a star    | POST   | http://localhost:8080/api/v2/stars   | {"name": "Proxima Centauri","constellation": "Centaurus", "distanceInLightYears": "4.2465","temperatureInKelvin": "2992"} | 201           |
| Get all stars | GET    | http://localhost:8080/api/v2/stars   |                                                                                                                           | 200           |
| Get a star    | GET    | http://localhost:8080/api/v2/stars/1 |                                                                                                                           | 200           |
| Update a star | PUT    | http://localhost:8080/api/v2/stars/1 | {"name": "Proxima Centauri","constellation": "Centaurus", "distanceInLightYears": "4.2465","temperatureInKelvin": "3000"} | 200           |
| Delete a star | DELETE | http://localhost:8080/api/v2/stars/1 |                                                                                                                           | 204           |

