package com.system.hotel.model;

import com.fasterxml.jackson.annotation.JsonFormat; // <-- Import JsonFormat
import jakarta.persistence.*;
import lombok.*; // Keep Lombok

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data // Includes Getters/Setters
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- ADD JsonFormat FOR DATE DESERIALIZATION ---
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
    // --- END DATE FORMAT ---

    private Long roomId;
    private Long userId;
    private String email;
    private Integer guests;
    private String name; // Customer name
    private String phone;
    private Long hotelId;
    private boolean confirmed;
}