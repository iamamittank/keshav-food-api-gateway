FROM openjdk:11-slim
ADD target/api-gateway-web.jar api-gateway-web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-gateway-web.jar"]