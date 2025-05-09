package com.system.hotel.Controller;

import com.system.hotel.model.Booking;
import com.system.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:8081") // Allow frontend access
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Endpoint to create a new booking
    @PostMapping("/process-booking")
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking){ // Use specific DTO if preferred
        try {
            Booking savedBooking = bookingService.saveBooking(booking);
            // Return the full saved booking object (includes the new ID)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking); // Use 201 Created
        } catch (IllegalArgumentException e) {
            // Catch validation errors from the service
            System.err.println("Booking validation error: " + e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage())); // 400
        } catch (Exception e) {
            // Catch database or other runtime errors from the service
            System.err.println("Error saving booking: " + e.getMessage());
            e.printStackTrace(); // Log stack trace for server debugging
            // Return a generic server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "An internal error occurred while processing the booking.")); // 500
        }
    }

    // Endpoint to get details for the confirmation page
    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingConfirmationDetails(@PathVariable Long bookingId) { // Use wildcard or specific DTO
        try {
            Map<String, Object> details = bookingService.getBookingDetailsForConfirmation(bookingId);
            if (details != null) {
                return ResponseEntity.ok(details); // Return 200 OK with the details map
            } else {
                // If service returns null (booking not found), return 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("success", false, "message", "Booking not found with ID: " + bookingId));
            }
        } catch (Exception e) {
            System.err.println("Error fetching booking details for ID " + bookingId + ": " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "An internal error occurred while fetching booking details.")); // 500
        }
    }

    // Optional: Endpoint to get all bookings (consider security/pagination later)
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            System.err.println("Error fetching all bookings: " + e.getMessage());
            e.printStackTrace();
            // Return an empty list or an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of());
        }
    }
}