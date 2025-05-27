# 설치
- 도커 사용
  - docker pull mongo
  - docker run -d --name choisinsa-mongo -p 27017:27017 --network choisinsa-app-network -v choisinsa-mongo-volume:/data/db -e MONGO_INITDB_ROOT_USERNAME={id} -e MONGO_INITDB_ROOT_PASSWORD={password} mongo:latest
  - docker exec -it choisinsa-mongo mongosh -u {id} -p