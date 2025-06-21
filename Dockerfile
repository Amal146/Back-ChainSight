# Build stage
FROM gradle:8.7.0-jdk17 AS build
WORKDIR /app
COPY backend/build.gradle .
COPY backend/settings.gradle .
COPY backend/gradle ./gradle
COPY backend/src ./src
RUN gradle bootJar --no-daemon -x test

# Run stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]