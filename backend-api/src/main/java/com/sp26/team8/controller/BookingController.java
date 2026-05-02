package com.sp26.team8.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.service.BookingService;
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking create(@RequestParam Long customerId,
                          @RequestParam Long serviceId,
                          @RequestParam String startDate,
                          @RequestParam String endDate,
                          @RequestParam String address) {
                            
        return bookingService.createBooking(
                customerId,
                serviceId,
                LocalDateTime.parse(startDate),
                LocalDateTime.parse(endDate),
                address
        );
    }

}

