# Spring Boot Microservice

This project is a simple Spring Boot microservice that connects to a MongoDB database and displays data on a web page. It demonstrates the use of Spring Boot, MongoDB, and Thymeleaf for web development.

## Project Structure

```
spring-boot-microservice
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── microservice
│   │   │               ├── controller
│   │   │               │   └── DataController.java
│   │   │               ├── model
│   │   │               │   └── Data.java
│   │   │               ├── repository
│   │   │               │   └── DataRepository.java
│   │   │               ├── service
│   │   │               │   └── DataService.java
│   │   │               └── SpringBootMicroserviceApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── templates
│   │           └── data.html
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── microservice
│                       └── SpringBootMicroserviceApplicationTests.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd spring-boot-microservice
   ```

2. **Configure MongoDB**:
   Update the `src/main/resources/application.properties` file with your MongoDB connection details.

3. **Build the project**:
   Use Maven to build the project:
   ```
   mvn clean install
   ```

4. **Run the application**:
   Start the Spring Boot application:
   ```
   mvn spring-boot:run
   ```

5. **Access the web page**:
   Open your web browser and navigate to `http://localhost:8080/data` to view the data retrieved from the database.

## Usage

This microservice provides a simple interface to interact with data stored in a MongoDB database. You can extend the functionality by adding more endpoints and business logic as needed.

## Dependencies

This project uses the following dependencies:
- Spring Boot
- Spring Data MongoDB
- Thymeleaf

## License

This project is licensed under the MIT License.