POSTGRESQL_CONTAINER=publisher_api_db
KEYCLOAK_CONTAINER=publisher_api_keycloak
SHELL=sh
BASH_SHELL=bash

.DEFAULT_GOAL=up

# Lift up the dev. environment
up:
	docker compose -f docker/docker-compose.yml up --build

# Take down the dev. environment
down:
	docker compose -f docker/docker-compose.yml down

# Take down the dev. environment and remove containers, images
fdown:
	docker compose -f docker/docker-compose.yml down --rmi all

# Connect to the shell of the container of the nodejs application
dbshell:
	docker exec -it ${POSTGRESQL_CONTAINER} ${SHELL}

kcshell:
	docker exec -it ${KEYCLOAK_CONTAINER} ${SHELL}