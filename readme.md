mvn clean spring-boot:run
curl -v localhost:8080/flora

sudo DOCKER_BUILDKIT=1 docker build -t juhnowski/florabolot .

sudo docker tag docker.io/juhnowski/florabolot cr.yandex/crp237cj1t7rnkmrc88e/florabolot

sudo docker push cr.yandex/crp237cj1t7rnkmrc88e/florabolot