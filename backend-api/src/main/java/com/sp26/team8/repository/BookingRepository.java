package com.sp26.team8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp26.team8.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
     List<Booking> findByCustomer_UserId(Long userId);
}
