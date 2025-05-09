# Horizon Bookings - Hotel Management System

## 🚀 Project Overview
Horizon Bookings is a fully-featured Hotel Management System designed to provide a seamless experience for both hotel customers and administrators. This application allows users to view, book, and manage hotel rooms while providing administrators with the tools to manage bookings and user information efficiently.

Built with scalability and user experience in mind, Horizon Bookings offers an intuitive interface that simplifies the hotel booking process while providing robust management capabilities. The system is designed to handle operations of various sizes, from boutique establishments to large hotel chains, with customizable features that can be tailored to specific business requirements.

## 🖼️ Project Screenshots
<img width="486" alt="image" src="https://github.com/user-attachments/assets/c497a835-564f-4c46-b2ca-d7b2b8ce06be" />
<img width="501" alt="image" src="https://github.com/user-attachments/assets/ea5de324-9b22-483e-a23b-7405784eb5b2" />
<img width="501" alt="image" src="https://github.com/user-attachments/assets/647a808a-29b7-47ef-b3fc-5765d4dd55bf" />
<img width="506" alt="image" src="https://github.com/user-attachments/assets/601a2ae3-ebfc-48f9-8fc6-4a8633ab33a9" />
<img width="502" alt="image" src="https://github.com/user-attachments/assets/a2def8c8-4ab7-4e1e-b3f5-64a1e2b41d05" />
<img width="505" alt="image" src="https://github.com/user-attachments/assets/0ee5bdf1-17a6-45c3-851e-ce3419d6f2d9" />
<img width="505" alt="image" src="https://github.com/user-attachments/assets/f1a5a27d-de06-4980-8c59-0f03851469d6" />

## 📌 Key Features
- **User Authentication & Authorization**
  - Secure login and registration system
  - Role-based access control (Admin, Staff, Customer)
  - Password recovery functionality

- **Hotel & Room Management**
  - Comprehensive hotel listing with detailed information
  - Search hotels by name, location, amenities, or price range
  - Advanced filtering options for room types and availability
  - Real-time room status updates

- **Booking System**
  - Intuitive booking interface with calendar integration
  - Room reservation with instant confirmation
  - Support for special requests and preferences
  - Flexible date modification and cancellation policies

- **User Dashboard**
  - Personalized dashboard for managing reservations
  - Booking history with detailed information
  - User profile management
  - Notification system for booking updates

- **Admin Controls**
  - Comprehensive admin panel for system management
  - Detailed analytics and reporting tools
  - Staff account management
  - Inventory and pricing control

## 🛠️ Technologies Used
- **Frontend:** 
  - Java Swing for Desktop Application
  - HTML5, CSS3, JavaScript for Web Interface
  - Bootstrap 5 for Responsive Design
  - jQuery for DOM Manipulation
  - AJAX for Asynchronous Operations

- **Backend:** 
  - Spring Boot 2.7.x (Java 11)
  - RESTful API Architecture
  - Spring Security for Authentication
  - JSON Web Tokens (JWT) for Stateless Authentication
  - Logger Integration (SLF4J with Logback)

- **Database:** 
  - MySQL 8.0.x
  - Connection Pooling with HikariCP
  - Database Migration with Flyway

- **Frameworks & Libraries:**
  - Spring MVC for Web Layer
  - Spring Data JPA for Data Access
  - Hibernate ORM for Object Mapping
  - ModelMapper for DTO Conversions
  - Apache Commons for Utilities

- **Testing:**
  - JUnit 5 for Unit Testing
  - Mockito for Mocking
  - Spring Test for Integration Testing

- **Build & Deployment:**
  - Gradle 7.x for Build Automation
  - Docker for Containerization
  - CI/CD Pipeline with GitHub Actions

## 🚀 How to Run the Project

### Prerequisites
- JDK 11 or higher
- MySQL 8.0.x
- Gradle 7.x (or use the included Gradle wrapper)
- Git

### Installation Steps

1. Clone the repository:
```bash
git clone https://github.com/yash-vks-chauhan/Hotel-Management-System-.git
cd Hotel-Management-System-
```

2. Set up MySQL database:
```bash
mysql -u root -p
CREATE DATABASE hotel_management;
CREATE USER 'hotelapp'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON hotel_management.* TO 'hotelapp'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

3. Configure application properties:
   - Navigate to `src/main/resources/`
   - Create a copy of `application.properties.sample` as `application.properties`
   - Update database credentials and other properties as needed:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_management?useSSL=false&serverTimezone=UTC
spring.datasource.username=hotelapp
spring.datasource.password=your_password

# JPA/Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true

# Server Properties
server.port=8080

# JWT Configuration
jwt.secret=your_jwt_secret_key
jwt.expiration=86400000
```

4. Build the project:
```bash
./gradlew clean build
```

5. Run the application:
```bash
./gradlew bootRun
```

6. Access the application:
   - Web Interface: http://localhost:8080
   - Swagger Documentation: http://localhost:8080/swagger-ui.html
   - API Base URL: http://localhost:8080/api/v1

### Docker Deployment (Alternative)
1. Build Docker image:
```bash
docker build -t horizon-bookings:latest .
```

2. Run with Docker Compose:
```bash
docker-compose up -d
```

## 📄 API Documentation
- API Documentation is configured using Swagger.
- Visit http://localhost:8080/swagger-ui.html to explore the APIs.

## 🌐 Project Structure
```
Hotel-Management-System
├── src/main/java
│   ├── com.system.hotel
│   │   ├── Controller (REST API Controllers)
│   │   ├── Model (Entity Classes)
│   │   ├── Repository (Database Repositories)
│   │   └── Service (Business Logic)
├── src/main/resources
│   ├── static
│   │   ├── login.html
│   │   ├── booking.html
│   │   ├── confirmation.html
│   │   ├── hotel-details.html
│   │   ├── hotels.html
│   │   ├── room.html
│   │   ├── script.js
│   │   └── styles.css
│   └── application.properties (Configuration)
├── build.gradle (Gradle Build File)
└── gradlew (Gradle Wrapper)
```

## 👨‍💻 Contributing
We welcome contributions to improve Horizon Bookings! Here's how you can contribute:

1. **Fork the repository**
2. **Create a feature branch**:
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**:
   ```bash
   git commit -m 'Add some amazing feature'
   ```
4. **Push to the branch**:
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Contribution Guidelines
- Follow the coding style and conventions used throughout the project
- Write and update tests for new features
- Update documentation as necessary
- Ensure all tests pass before submitting pull requests
- Reference relevant issues in your pull request

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔮 Future Roadmap
- Mobile application development (iOS and Android)
- Integration with popular payment gateways
- Multilingual support
- Advanced analytics dashboard
- AI-powered recommendation system
- Integration with third-party booking platforms

## 📞 Contact
For any inquiries, please reach out at: yash-vks-chauhan@gmail.com

## 🙏 Acknowledgements
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate](https://hibernate.org/)
- [MySQL](https://www.mysql.com/)
- [Bootstrap](https://getbootstrap.com/)
- All the contributors who have helped shape this project
