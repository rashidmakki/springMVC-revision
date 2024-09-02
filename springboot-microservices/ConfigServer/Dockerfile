# Use a base image with Java and a JRE
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host into the container
COPY target/ConfigServer-0.0.1-SNAPSHOT.jar ./ConfigServer-0.0.1-SNAPSHOT.jar

# Command to run the Spring Boot application
CMD ["java", "-jar", "ConfigServer-0.0.1-SNAPSHOT.jar"]