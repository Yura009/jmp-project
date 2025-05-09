
# JMP Project

## Overview

This project demonstrates the use of Java 9+ modules, Maven multi-module structure, and modern Java features such as lambdas, Stream API, `ServiceLoader`, and method references. It simulates a banking and subscription service system with multiple implementations.

## Modules

- **jmp-bank-api**: Contains the `Bank` interface and related definitions.
- **jmp-service-api**: Contains the `Service` interface with user subscription functionalities.
- **jmp-cloud-bank-impl**: Implements the `Bank` interface with three types of banks: `RetailBank`, `InvestmentBank`, and `CentralBank`.
- **jmp-cloud-service-impl**: Implements the `Service` interface and provides methods for managing subscriptions and calculating user statistics.
- **jmp-dto**: Defines the data transfer objects like `User`, `BankCard`, and `Subscription`.

## Key Features

- Java module system (`module-info.java`)
- Usage of `Optional`, lambdas, `Stream API`, and method references
- Demonstrates `ServiceLoader` for dynamic loading of service implementations
- Custom exceptions
- Use of `Collectors.toUnmodifiableList()`
- Maven multi-module structure

## Getting Started

To build and run this project:

1. Make sure you have Java 11+ and Maven installed.
2. Clone this repository:
   ```bash
   git clone https://github.com/Yura009/jmp-project.git
   cd jmp-project
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application from the `jmp-application` module.

## Author

Developed by [Yura009](https://github.com/Yura009)
