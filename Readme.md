# Message Queue Processor

## Overview

This project is a simple message-driven application in core Java that simulates a producer-consumer scenario using a message queue. It includes a producer that generates messages, a consumer that processes these messages, and a feature to track the number of successfully processed messages and errors encountered.

## Features

- Simulates a producer-consumer scenario using a `BlockingQueue`.
- Tracks and logs the total number of messages processed successfully.
- Logs the number of errors encountered during processing.
- Handles failed messages by redirecting them to a dead-letter queue.
- Includes unit tests for both successful and failure scenarios.

## Prerequisites

- Java 11 or higher installed
- Maven 3.6+ installed

## Setup and Installation
```bash
mvn clean install
```

## Running the Application
```bash
java -jar target/MessageQueueProcessor-1.0.0.jar
```
   
 
