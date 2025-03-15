package com.vivah.makeUp_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "makeup_artists")
@Data

public class MakeupArtists {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key
    @JsonIgnore
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;  // Primary Key

    @Column(nullable = false, length = 500)
    private String bio;

    @Column(nullable = false, unique = true, length = 12)
    private String adharNum;


    @Column(nullable = false)
    private Integer experience; // In years

    @ElementCollection
    @CollectionTable(name = "artist_services", joinColumns = @JoinColumn(name = "artist_id"))
    @Column(name = "service")
    private List<String> services;  // Services provided by the artist

    @Column(nullable = false, length = 255)
    private String expertise; // Example: "Bridal, Party Makeup, HD Makeup"

    @Column(nullable = false)
    private Double rating = 0.0;  // Default rating

    @Column(nullable = false, length = 50)
    private String priceRange; // Example: "₹5000 - ₹20000"

    @Column(nullable = false)
    private Boolean isVerified = false;

    @Column(nullable = false, length = 255)
    private String location; // Example: "Delhi, Mumbai"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArtistStatus status = ArtistStatus.PENDING; // PENDING, APPROVED, REJECTED
}
