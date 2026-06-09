package com.HotelReservation.model;

public class Booking {
    private String bookingId;
    private Room room;
    private String guestName;
    private String guestEmail;

    public Booking(String bookingId, Room room, String guestName, String guestEmail) {
        this.bookingId = bookingId;
        this.room = room;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
    }

    public String getBookingId() { return bookingId; }
    public Room getRoom() { return room; }
    public String getGuestName() { return guestName; }
    public String getGuestEmail() { return guestEmail; }
}