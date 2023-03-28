mvn clean spring-boot:run
curl -v localhost:8080/flora

DOCKER_BUILDKIT=1 docker build -t juhnowski/florabolot .