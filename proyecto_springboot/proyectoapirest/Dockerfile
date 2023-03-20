FROM openjdk:17-jdk-alpine
MAINTAINER mayra
RUN addgroup -S spring && adduser -S adduser -S spring -G spring
USER root:root
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} proyectoapirest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/proyectoapirest-0.0.1-SNAPSHOT.jar"]