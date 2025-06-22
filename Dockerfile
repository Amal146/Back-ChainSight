# Stage 1: Build
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app
COPY . .
RUN chmod +x gradlew && \
    ./gradlew build

# Stage 2: Run
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]