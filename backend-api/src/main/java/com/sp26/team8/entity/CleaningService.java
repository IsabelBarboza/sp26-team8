package com.sp26.team8.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    
  @ManyToOne
  @JoinColumn(name = "provider_id", nullable = false)
  @JsonIgnoreProperties("services")
  private Provider provider;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceStatus status;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Booking> bookings;

    public enum ServiceStatus {
        ACTIVE, INACTIVE
    }

    
}
/*
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningService {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long serviceId;

  @ManyToOne
  @JoinColumn(name = "provider_id", nullable = false)
  @JsonIgnoreProperties("services")
  private Provider provider;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ServiceStatus status;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties({ "service" })
  private List<Booking> bookings;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  public enum ServiceStatus {
     ACTIVE, INACTIVE
  }

 
}
*/