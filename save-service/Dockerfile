FROM openjdk:11-ea-jdk-slim
VOLUME /tmp
COPY build/libs/save-service-1.0.jar SaveService.jar
ENTRYPOINT ["java", "-jar", "SaveService.jar"]