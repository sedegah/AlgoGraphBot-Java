# ===== Stage 1: Build =====
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy your source code
COPY . .

# Build the app
RUN mvn clean package -DskipTests

# ===== Stage 2: Run =====
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the compiled JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Run the bot
ENTRYPOINT ["java", "-jar", "app.jar"]
