FROM alpine/java:22-jdk
COPY target/spring-boot-microservice-0.0.1-SNAPSHOT.jar spring-app.jar
ENTRYPOINT ["java", "-jar", "/spring-app.jar"]
