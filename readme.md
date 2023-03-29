# Сервис "Флора болот" для Керженского заповедника

- http://51.250.86.64:8080/v3/api-docs/ 
- http://51.250.86.64:8080/swagger-ui.html
- http://51.250.86.64:8080//actuator

## Очередность развертывания
Клонируем из репозитория
```
git clone https://github.com/juhnowski/florabolot.git
```

Проверяем работоспособность
```
mvn clean spring-boot:run
curl -v localhost:8080/flora
```

Создаем образ
```
sudo DOCKER_BUILDKIT=1 docker build -t juhnowski/florabolot .
```

Смотри, что он появился
```
sudo docker image list
```

Копируем образ в реестр (образ уже в двух репозиториях)
```
// этот реестр пока не используется,но можно и в него
sudo docker tag docker.io/juhnowski/florabolot cr.yandex/crp237cj1t7rnkmrc88e/florabolot
sudo docker push cr.yandex/crp237cj1t7rnkmrc88e/florabolot

// этот реестр основной 
sudo docker tag docker.io/juhnowski/florabolot cr.yandex/crpbk6v2e0thk6bm4s38/florabolot
sudo docker push cr.yandex/crpbk6v2e0thk6bm4s38/florabolot
```

Проверяем что все работает
```
sudo docker run -p 8080:8080 cr.yandex/crpbk6v2e0thk6bm4s38/florabolot
```

Создаем виртуальную машину
```
yc compute instance create-with-container \
  --name florabolot \
  --zone ru-central1-a \
  --ssh-key ~/.ssh/id_ed25519.pub \
  --create-boot-disk size=30 \
  --network-interface subnet-name=default-ru-central1-a,nat-ip-version=ipv4 \
  --service-account-name dev \
  --docker-compose-file docker-compose.yaml
```
Для работы с сервисом можно использовать экспортированную коллекцию запросов Postman https://www.postman.com/

```
kerzhenskiy.postman_collection.json
```