# Build stage
FROM gradle:8.7.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon --stacktrace -x test

# Run stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]