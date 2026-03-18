package com.sp26.team8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ReviewRepository extends JpaRepository<Review, Long> {
  @Query(value = "SELECT r.* FROM reviews r WHERE r.provider_id = :providerId", nativeQuery = true)
  List<Review> findByProviderId(Long providerId);

  @Query(value = "SELECT r.* FROM reviews r WHERE r.customer_id = :customerId", nativeQuery = true)
  List<Review> findByCustomerId(Long customerId);

  @Query(value = "SELECT r.* FROM reviews r WHERE r.booking_id = :bookingId", nativeQuery = true)
  List<Review> findByBookingId(Long bookingId);

}
