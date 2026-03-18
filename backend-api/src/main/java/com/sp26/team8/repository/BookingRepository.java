
package com.sp26.team8.repository;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.entity.Booking.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  @Query(value = "SELECT b.* FROM bookings b WHERE b.customer_id = :customerId", nativeQuery = true)
    List<Booking> findByCustomerId(Long customerId);
    @Query(value = "SELECT b.* FROM bookings b WHERE b.service_id = :serviceId", nativeQuery = true)
    List<Booking> findByServiceId(Long serviceId);
    List<Booking> findByStatus(BookingStatus status);
}