FROM openjdk:11-ea-jdk-slim
VOLUME /tmp
COPY build/libs/list-service-1.0.jar ListService.jar
ENTRYPOINT ["java", "-jar", "ListService.jar"]