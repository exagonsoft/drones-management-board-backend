# Stage 1: Build the application
FROM maven:latest AS build
WORKDIR /dronesapp
COPY pom.xml .
COPY ./ ./
RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /dronesapp
COPY --from=build /dronesapp/target/drones-backend-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "drones-backend-0.0.1-SNAPSHOT.jar"]

