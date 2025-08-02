# Stage 1: Build
FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN gradle build -x test --no-daemon


# Stage 2: Run
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
