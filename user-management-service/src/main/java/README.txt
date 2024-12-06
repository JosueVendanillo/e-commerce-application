src/
├── main/
│   ├── java/com/example/usermanagement/
│   │   ├── config/                  # Security, Swagger, and general configurations
│   │   │   ├── SecurityConfig.java
│   │   │   ├── SwaggerConfig.java
│   │   ├── controller/              # REST Controllers
│   │   │   ├── UserController.java
│   │   ├── dto/                     # Data Transfer Objects
│   │   │   ├── UserDTO.java
│   │   ├── entity/                  # Entities
│   │   │   ├── User.java
│   │   │   ├── Audit.java
│   │   ├── exception/               # Custom exception handlers
│   │   │   ├── GlobalExceptionHandler.java
│   │   ├── repository/              # Repositories
│   │   │   ├── UserRepository.java
│   │   │   ├── AuditRepository.java
│   │   ├── service/                 # Service layer
│   │   │   ├── UserService.java
│   │   │   ├── AuditService.java
│   │   ├── events/                  # Kafka events
│   │   │   ├── UserEvent.java
│   │   │   ├── KafkaProducer.java
│   │   ├── UserManagementApplication.java
├── resources/
│   ├── application.properties
├── test/
│   ├── java/com/example/usermanagement/
│   │   ├── UserControllerTest.java
│   │   ├── UserServiceTest.java
