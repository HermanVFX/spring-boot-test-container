FROM openjdk:17-jdk-slim
WORKDIR application
ARG JAR_FILE=build/libs/spring-boot-test-container-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]