package com.system.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter // Lombok: Generate getters for all fields
@Setter // Lombok: Generate setters for all fields
@NoArgsConstructor // Lombok: Generate no-args constructor (required by JPA)
@AllArgsConstructor // Lombok: Generate all-args constructor (includes new field)
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private double price;
    private boolean available;

    // --- ADDED description FIELD ---
    @Column(length = 1000) // Optional: Specify column length if needed
    private String description; // Getter: getDescription(), Setter: setDescription() generated
    // --- END ADDED FIELD ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonIgnore // Exclude hotel from JSON serialization
    private Hotel hotel;

}