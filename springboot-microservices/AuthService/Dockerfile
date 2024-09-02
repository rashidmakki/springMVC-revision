# Use a base image with Java and a JRE
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host into the container
COPY target/AuthService-0.0.1-SNAPSHOT.jar ./AuthService-0.0.1-SNAPSHOT.jar

# Command to run the Spring Boot application
CMD ["java", "-jar", "AuthService-0.0.1-SNAPSHOT.jar"]