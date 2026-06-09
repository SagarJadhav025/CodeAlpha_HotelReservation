# 🏨 Sagar's Hotel Reservation System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![HTML/CSS](https://img.shields.io/badge/HTML5_&_CSS3-E34F26?style=for-the-badge&logo=html5&logoColor=white)

A full-stack, web-based Hotel Reservation System built using **Java Spring Boot**. This application allows users to view available rooms, make a booking, simulate payments, and receive a real confirmation email.

## ✨ Features

* **Modern Web Interface:** A beautiful, animated UI built with HTML, CSS, and Thymeleaf.
* **Room Management:** 32 automatically generated rooms divided into 3 tiers (Standard, Deluxe, Suite).
* **Real-Time Availability:** Rooms are instantly marked as "Booked" and disabled upon successful payment.
* **Payment Simulation:** Processes simulated card payments before confirming a booking.
* **Persistent Storage (File I/O):** Saves all confirmed bookings (Guest Name, Email, Room ID, Booking ID) permanently to a `bookings.txt` file.
* **Email Notifications:** Uses `spring-boot-starter-mail` (SMTP) to send real, formatted booking confirmation tickets directly to the customer's inbox.

## 🛠️ Tech Stack

* **Backend:** Java 17+, Spring Boot (Web, Mail)
* **Frontend:** Thymeleaf, HTML5, Modern CSS3
* **Storage:** Java File I/O (`java.io.FileWriter`)
* **Build Tool:** Maven

🚀 How to Run Locally
1. Prerequisites
  i. Java Development Kit (JDK) 17 or higher installed.

  ii. Maven installed.

  iii. An IDE like IntelliJ IDEA or Eclipse.

2. Setup Email Configuration
To enable the email notification feature, you must configure your Gmail SMTP settings.
Open src/main/resources/application.properties and add:

Properties


spring.mail.host=smtp.gmail.com

spring.mail.port=587

spring.mail.username=your-email@gmail.com

spring.mail.password=your-16-digit-app-password

spring.mail.properties.mail.smtp.auth=true

spring.mail.properties.mail.smtp.starttls.enable=true

(Note: You must use a Google "App Password", not your standard Gmail password).


3. Build and Run
Clone the repository:

Bash
git clone [https://github.com/YourUsername/Hotel-Reservation-System.git](https://github.com/YourUsername/Hotel-Reservation-System.git)
Open the project in your IDE and let Maven download the dependencies.

Run the SagarApplication.java file.

Open your web browser and navigate to: http://localhost:8080

🔮 Future Enhancements
Integrate a relational database (MySQL/PostgreSQL) using Spring Data JPA to replace File I/O.

Integrate a real payment gateway (like Stripe or Razorpay).

Add a dedicated Admin Dashboard to cancel bookings and manage room inventory.

Developed with ❤️ by Sagar
