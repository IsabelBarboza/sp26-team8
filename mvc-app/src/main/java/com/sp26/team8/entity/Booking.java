package com.sp26.team8.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private CleaningService service;

    @Enumerated(EnumType.STRING)
private BookingStatus status;

    @Column( nullable = false)
    private LocalDateTime startDate;

    @Column( nullable = false)
    private LocalDateTime endDate;

    @Column( nullable = true)
     private String address;

     @Column( nullable = false)
      private double totalPrice;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column( nullable = false)
    private LocalDateTime updatedAt;
    
    private Double hours;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public enum BookingStatus {
    ACTIVE,
    CANCELLED,
    COMPLETED
}
}
