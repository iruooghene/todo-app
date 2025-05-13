# Stage 1: Build the application
FROM maven:3.8.7 AS build

# Set working directory inside the container
WORKDIR /app

# Copy your project files into the container
COPY . .

# Package the application, skipping tests
RUN mvn -B clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17

# Set working directory for runtime container
WORKDIR /app

# Copy the built jar from the build stage to the runtime image
COPY --from=build /app/target/*.jar TodoApp.jar

# Expose the app port (optional but good practice)
EXPOSE 8017

# Run the jar file
ENTRYPOINT ["java", "-jar", "-Dserver.port=8017", "TodoApp.jar"]
