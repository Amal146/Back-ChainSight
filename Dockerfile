# Use a JDK base image
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
COPY . .

# Give execute permission and build using wrapper
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# Runtime image
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
