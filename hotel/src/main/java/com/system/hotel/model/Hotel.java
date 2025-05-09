package com.system.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "hotels")
public class Hotel {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double pricePerNight;
    private String description;
    private String amenities;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private String contact;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // Prevents infinite recursion when serializing JSON responses
    private List<Room> rooms;

    // Constructors
    public Hotel() {
    }

    public Hotel(String name, String location, double pricePerNight, String description, String amenities, double rating, String contact, String imageUrl) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.amenities = amenities;
        this.rating = rating;
        this.contact = contact;
        this.imageUrl = imageUrl;
    }

}