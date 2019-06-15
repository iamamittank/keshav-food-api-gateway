FROM openjdk:11-jdk-slim

COPY target/api-gateway-web.jar software/applications/api-gateway-web.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "software/applications/api-gateway-web.jar"]