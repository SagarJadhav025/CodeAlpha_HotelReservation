package com.HotelReservation.service;

import com.HotelReservation.model.Booking;
import com.HotelReservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelService {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    // 📩 Inject the real mail sender tool
    @Autowired
    private JavaMailSender mailSender;

    public HotelService() {
        // Generate rooms
        for (int i = 1; i <= 10; i++) rooms.add(new Room(i, "Standard", 100.0));
        for (int i = 11; i <= 22; i++) rooms.add(new Room(i, "Deluxe", 250.0));
        for (int i = 23; i <= 32; i++) rooms.add(new Room(i, "Suite", 500.0));
    }

    public List<Room> getAllRooms() { return rooms; }

    public Booking processBooking(int roomId, String name, String email) {
        for (Room room : rooms) {
            if (room.getId() == roomId && room.isAvailable()) {
                room.setAvailable(false);
                String uniqueId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
                Booking newBooking = new Booking(uniqueId, room, name, email);
                bookings.add(newBooking);

                saveBookingToFile(newBooking);

                // 🚀 CALL THE REAL EMAIL FUNCTION HERE
                sendRealEmail(email, name, uniqueId, room);

                return newBooking;
            }
        }
        return null;
    }

    // ✉️ New method to construct and transmit the real message
    private void sendRealEmail(String toEmail, String guestName, String bookingId, Room room) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("your-hotel-email@gmail.com"); // Must match application.properties username
            message.setTo(toEmail);
            message.setSubject("🏨 Booking Confirmed! ID: " + bookingId);

            // Text Body
            String body = "Dear " + guestName + ",\n\n" +
                    "Thank you for choosing Sagar's Luxury Hotel! Your reservation is confirmed.\n\n" +
                    "📌 Booking Details:\n" +
                    "---------------------------\n" +
                    "• Booking ID: " + bookingId + "\n" +
                    "• Room Selected: Room " + room.getId() + " (" + room.getType() + ")\n" +
                    "• Price Paid: $" + room.getPrice() + "\n" +
                    "---------------------------\n\n" +
                    "We look forward to hosting you!\n\nBest regards,\nSagar's Hotel Team";

            message.setText(body);
            mailSender.send(message); // Transmits across the web!
            System.out.println("✅ Real email successfully sent to " + toEmail);
        } catch (Exception e) {
            System.out.println("❌ Failed to send real email: " + e.getMessage());
        }
    }

    private void saveBookingToFile(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookings.txt", true))) {
            writer.write("ID: " + booking.getBookingId() + " | Name: " + booking.getGuestName() +
                    " | Email: " + booking.getGuestEmail() + " | Room: " + booking.getRoom().getId() + "\n");
        } catch (IOException e) {
            System.out.println("⚠️ Could not save to file.");
        }
    }
}