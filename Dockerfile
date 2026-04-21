FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN apk add --no-cache \
    curl \
    busybox-extras \
    bash

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]