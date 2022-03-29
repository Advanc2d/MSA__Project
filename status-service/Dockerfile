FROM openjdk:11-ea-jdk-slim
VOLUME /tmp
COPY build/libs/status-service-1.0.jar StatusService.jar
ENTRYPOINT ["java", "-jar", "StatusService.jar"]