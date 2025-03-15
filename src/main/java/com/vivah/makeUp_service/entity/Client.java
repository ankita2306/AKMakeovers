package com.vivah.makeUp_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "clients")
@Data
public class Client  {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key
    @JsonIgnore
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long clientId;

   /* @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
*/
    @Column(columnDefinition = "TEXT")
    private String preferences;

    @Column(nullable = false, length = 255)
    private String location;

    @Column(length = 50)
    private String budgetRange;

    @Column(length = 100)
    private String eventType;

    @Column
    private LocalDate eventDate;

    @Column
    private LocalTime eventTime;
}
