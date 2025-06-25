# Use OpenJDK 21
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy built jar
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
