package com.HotelReservation.controller;

import com.HotelReservation.model.Booking;
import com.HotelReservation.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {

    private final HotelService hotelService;

    // Connect the Service to the Controller
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String showRooms(Model model) {
        model.addAttribute("rooms", hotelService.getAllRooms());
        return "index";
    }

    @PostMapping("/book")
    public String bookRoom(@RequestParam int roomId,
                           @RequestParam String guestName,
                           @RequestParam String guestEmail,
                           Model model) {

        Booking confirmedBooking = hotelService.processBooking(roomId, guestName, guestEmail);

        if (confirmedBooking != null) {
            model.addAttribute("booking", confirmedBooking);
            return "details"; // Send them to the booking details page!
        } else {
            model.addAttribute("error", "❌ Room is already booked or invalid.");
            model.addAttribute("rooms", hotelService.getAllRooms());
            return "index";
        }
    }
}