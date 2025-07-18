# Use Eclipse Temurin JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the compiled jar (update to correct name)
COPY target/AlgoGraphBot-1.0.jar bot.jar

# Run the bot
CMD ["java", "-jar", "bot.jar"]
