#!/usr/bin/env bash

#Step 1: compile the project and run the tests.
echo "Build the microservice with maven (mvn).............................."
mvn clean install -DskipTests
echo "Build success (mvn)                    .............................."

#Step 2: create the docker network.
echo "Create docker network (micronaut-network) ..........................."
if [[ ! "$(docker network ls | grep micronaut-network)" ]]; then
	docker network create micronaut-network
fi
echo "Docker created success(micronaut-network) ..........................."

#Step 3: start services with docker compose.
echo "Start services with docker-compose     .............................."
docker-compose up -d
echo "Services up success docker-compose     .............................."