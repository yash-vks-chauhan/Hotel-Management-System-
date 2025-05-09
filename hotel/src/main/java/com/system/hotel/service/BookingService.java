package com.system.hotel.service;

import com.system.hotel.model.Booking;
import com.system.hotel.model.Hotel;
import com.system.hotel.model.Room;
import com.system.hotel.repository.BookingRepository;
import com.system.hotel.repository.HotelRepository; // Required
import com.system.hotel.repository.RoomRepository;  // Required
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Good practice for save

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository; // Inject Room Repo
    @Autowired
    private HotelRepository hotelRepository; // Inject Hotel Repo

    @Transactional // Add transaction management for saving
    public Booking saveBooking(Booking booking) {
        // --- Basic Validation before save ---
        if (booking.getUserId() == null || booking.getHotelId() == null || booking.getRoomId() == null ||
                booking.getName() == null || booking.getName().isBlank() ||
                booking.getEmail() == null || booking.getEmail().isBlank() ||
                booking.getPhone() == null || booking.getPhone().isBlank() ||
                booking.getCheckInDate() == null || booking.getCheckOutDate() == null ||
                booking.getGuests() == null || booking.getGuests() <= 0) {
            throw new IllegalArgumentException("Missing required booking information.");
        }
        if (booking.getCheckOutDate().isBefore(booking.getCheckInDate()) || booking.getCheckOutDate().isEqual(booking.getCheckInDate())) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        // Optional: Add checks for User/Hotel/Room existence here if needed,
        // although DB constraints will also catch this.
        // Optional: Check room availability for the given dates (more complex logic)

        System.out.println("Saving booking: " + booking);
        try {
            // Ensure confirmed is false by default if not explicitly set
            booking.setConfirmed(false);
            Booking savedBooking = bookingRepository.save(booking);
            System.out.println("Booking saved successfully with ID: " + savedBooking.getId());
            return savedBooking;
        } catch (Exception e) {
            System.err.println("!!! Database error during booking save: " + e.getMessage());
            // Log full trace for debugging backend issues
            e.printStackTrace();
            // Rethrow a more specific runtime exception to trigger 500 error clearly
            throw new RuntimeException("Failed to save booking due to a database issue.", e);
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Method to get combined details for the confirmation page
    public Map<String, Object> getBookingDetailsForConfirmation(Long bookingId) {
        System.out.println("Fetching confirmation details for Booking ID: " + bookingId);
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isEmpty()) {
            System.out.println("Booking not found for ID: " + bookingId);
            return null; // Not found
        }

        Booking booking = bookingOpt.get();
        Map<String, Object> details = new HashMap<>();

        // Add core booking details using standard Java Bean naming (matched by Lombok @Data)
        details.put("bookingId", booking.getId());
        details.put("customerName", booking.getName());
        details.put("email", booking.getEmail());
        details.put("phone", booking.getPhone());
        details.put("checkInDate", booking.getCheckInDate()); // Will be serialized as string e.g., "2025-05-06"
        details.put("checkOutDate", booking.getCheckOutDate());// Will be serialized as string
        details.put("guests", booking.getGuests());
        details.put("roomId", booking.getRoomId());
        details.put("hotelId", booking.getHotelId());
        details.put("userId", booking.getUserId());
        details.put("confirmed", booking.isConfirmed());

        // Fetch and add Room details
        if (booking.getRoomId() != null) {
            roomRepository.findById(booking.getRoomId()).ifPresentOrElse(room -> {
                details.put("roomType", room.getType());
                details.put("roomPrice", room.getPrice());
                System.out.println("Found Room details: Type=" + room.getType() + ", Price=" + room.getPrice());
            }, () -> {
                System.out.println("Room details not found for Room ID: " + booking.getRoomId());
                details.put("roomType", "N/A (Not Found)");
                details.put("roomPrice", "N/A");
            });
        } else {
            details.put("roomType", "N/A (Not Specified)"); details.put("roomPrice", "N/A");
        }

        // Fetch and add Hotel details
        if (booking.getHotelId() != null) {
            hotelRepository.findById(booking.getHotelId()).ifPresentOrElse(hotel -> {
                details.put("hotelName", hotel.getName()); // Assumes Hotel has getName()
                details.put("hotelLocation", hotel.getLocation()); // Assumes Hotel has getLocation()
                System.out.println("Found Hotel details: Name=" + hotel.getName());
            }, () -> {
                System.out.println("Hotel details not found for Hotel ID: " + booking.getHotelId());
                details.put("hotelName", "N/A (Not Found)");
                details.put("hotelLocation", "N/A");
            });
        } else {
            details.put("hotelName", "N/A (Not Specified)"); details.put("hotelLocation", "N/A");
        }

        System.out.println("Returning confirmation details map: " + details);
        return details;
    }
}