# Dockerfile

FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy your JAR
COPY target/gestion-competences-1.0.0.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
