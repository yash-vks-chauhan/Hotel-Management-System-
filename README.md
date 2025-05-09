# Horizon Bookings - Hotel Management System

## 🚀 Project Overview
Horizon Bookings is a fully-featured Hotel Management System designed to provide a seamless experience for both hotel customers and administrators. This application allows users to view, book, and manage hotel rooms while providing administrators with the tools to manage bookings and user information efficiently.

## 🖼️ Project Screenshots
<img width="486" alt="image" src="https://github.com/user-attachments/assets/c497a835-564f-4c46-b2ca-d7b2b8ce06be" />
<img width="501" alt="image" src="https://github.com/user-attachments/assets/ea5de324-9b22-483e-a23b-7405784eb5b2" />
<img width="501" alt="image" src="https://github.com/user-attachments/assets/647a808a-29b7-47ef-b3fc-5765d4dd55bf" />
<img width="506" alt="image" src="https://github.com/user-attachments/assets/601a2ae3-ebfc-48f9-8fc6-4a8633ab33a9" />
<img width="502" alt="image" src="https://github.com/user-attachments/assets/a2def8c8-4ab7-4e1e-b3f5-64a1e2b41d05" />
<img width="505" alt="image" src="https://github.com/user-attachments/assets/0ee5bdf1-17a6-45c3-851e-ce3419d6f2d9" />
<img width="505" alt="image" src="https://github.com/user-attachments/assets/f1a5a27d-de06-4980-8c59-0f03851469d6" />

## 📌 Key Features
- User Authentication (Login & Registration)
- View Available Hotels
- Search Hotels by Name or Location
- Hotel Room Management
- Room Booking with Booking Confirmation
- User Dashboard to Manage Bookings

## 🛠️ Technologies Used
- **Frontend:** Java Swing (For Desktop GUI), HTML, CSS, JavaScript
- **Backend:** Spring Boot (Java), REST API
- **Database:** MySQL
- **Frameworks:** Spring MVC, Spring Data JPA, Hibernate
- **Build Tool:** Gradle

## 🚀 How to Run the Project
1. Clone the repository:
```bash
git clone https://github.com/yash-vks-chauhan/Hotel-Management-System-.git
cd Hotel-Management-System-
```

2. Set up MySQL database:
   - Create a database named `hotel_management`.
   - Set your MySQL credentials in `application.properties`.

3. Run the Spring Boot application:
```bash
./gradlew bootRun
```

4. Access the application on http://localhost:8080.

## 📄 API Documentation
- API Documentation is configured using Swagger.
- Visit http://localhost:8080/swagger-ui.html to explore the APIs.

## 🌐 Project Structure
```
Hotel-Management-System
├── src/main/java
│   ├── com.system.hotel (Main Application Package)
│   ├── Controller (All Controllers)
│   ├── Model (Entity Classes)
│   ├── Repository (Database Repositories)
│   └── Service (Business Logic)
├── src/main/resources
│   ├── static (HTML, CSS, JS for Frontend)
│   └── application.properties (Configuration)
└── gradlew (Gradle Wrapper)
```

## 👨‍💻 Contributing
Feel free to open issues or submit pull requests for improvements and bug fixes.

## 📞 Contact
For any inquiries, please reach out at: yash-vks-chauhan@example.com
