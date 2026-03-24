package com.sp26.team8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    

    @PostMapping("/{customerId}/{serviceId}")
    public Booking createBooking(@PathVariable Long customerId,
                                 @PathVariable Long serviceId) {
        return bookingService.createBooking(customerId, serviceId);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
/* 
import com.sp26.team8.entity.Booking;
import com.sp26.team8.entity.Booking.BookingStatus;
import com.sp26.team8.service.BookingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingsByCustomerId(@PathVariable Long customerId) {
        List<Booking> bookings = bookingService.getBookingsByCustomerId(customerId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<Booking>> getBookingsByServicesId(@PathVariable Long serviceId) {
        List<Booking> bookings = bookingService.getBookingsByServiceId(serviceId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByStatus(@PathVariable BookingStatus status) {
        List<Booking> bookings = bookingService.getBookingsByStatus(status);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id,
            @RequestBody Booking bookingDetails) {
        try {
            Booking updatedBooking = bookingService.updateBooking(id, bookingDetails);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}*/
