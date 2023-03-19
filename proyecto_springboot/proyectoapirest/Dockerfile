FROM openjdk:8-jdk-alpine
MAINTAINER mayra
RUN adddgroup -S spring && adduser -S adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} proyectoapirest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/proyectoapirest-0.0.1-SNAPSHOT.jar"]