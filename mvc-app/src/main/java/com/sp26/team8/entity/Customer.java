package com.sp26.team8.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "customer_id")

public class Customer extends User {

  @Column(nullable = false)
   private String name;

  @Column
    private String phoneNumber;

  @Column
    private String address;

@OneToMany(mappedBy = "customer")
@JsonIgnore
private List<Review> reviews;

@OneToMany(mappedBy = "customer")
@JsonIgnore
private List<Booking> bookings;



}
