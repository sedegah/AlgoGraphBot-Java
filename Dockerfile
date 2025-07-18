# Use a slim base Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/AlgoGraphBot-1.0-jar-with-dependencies.jar bot.jar

# Expose a dummy port (required by Cloud Run even if not used)
EXPOSE 8080

# Run the bot
CMD ["java", "-jar", "bot.jar"]
