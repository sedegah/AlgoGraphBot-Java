# AlgoGraphBot

AlgoGraphBot is a Java-based Telegram bot that teaches and visualizes algorithms. It provides clear definitions and step-by-step explanations of popular searching and sorting algorithms.

## Features

- Provides definitions of algorithms before execution
- Supports common searching algorithms:
  - Linear Search
  - Binary Search
- Supports common sorting algorithms:
  - Bubble Sort
  - Insertion Sort
  - Selection Sort
- Produces detailed step-by-step outputs
- Telegram bot integration via Telegram Bot API
- Secure configuration using `application.properties` and environment variables (compatible with Render)

## Project Structure

```

src/main/
├── java/com/algograph/
│   ├── AlgoBot.java           # Main bot class
│   ├── AlgoHandler.java       # Handles incoming Telegram messages
│   ├── AlgoSelector.java      # Routes algorithm type to appropriate module
│   ├── Searching.java         # Searching algorithms and definitions
│   ├── Sorting.java           # Sorting algorithms and definitions
├── resources/
│   └── application.properties # Environment-based bot configuration
README.md
pom.xml

```

## Requirements

- Java 17+
- Maven 3.6+
- A Telegram Bot Token (created via BotFather)
- Render account for deployment (or any other Java-supported cloud platform)

