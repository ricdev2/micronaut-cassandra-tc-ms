#!/usr/bin/env bash

docker-compose down

if [[ "$(docker network ls | grep micronaut-network)" ]]; then
	docker network rm micronaut-network
fi