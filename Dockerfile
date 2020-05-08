FROM openjdk:8-jdk-alpine
ADD build/libs/shopping-list-service.jar shopping-list-service.jar
EXPOSE 8083:8083
ENTRYPOINT ["java","-jar","shopping-list-service.jar"]