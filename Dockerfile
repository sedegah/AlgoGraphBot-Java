# Use a base image with Java 17
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the compiled JAR from the build context
COPY target/algobot-1.0.jar app.jar

# Set the entrypoint to run your bot
ENTRYPOINT ["java", "-jar", "app.jar"]
