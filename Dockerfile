# Use a lightweight OpenJDK image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built jar from the host to the container
COPY target/*.jar app.jar

# Expose port 8080 (or your app's configured port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]