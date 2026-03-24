package com.sp26.team8.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.entity.Customer;
import com.sp26.team8.entity.Review;
import com.sp26.team8.service.BookingService;
import com.sp26.team8.service.CustomerService;
import com.sp26.team8.service.ReviewService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> existing = customerService.getCustomerById(id);
        if (existing.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("Error updating customer: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // For validation errors
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

   @PostMapping("/{customerId}/book/{serviceId}")
    public ResponseEntity<Booking> bookService(
        @PathVariable Long customerId,
        @PathVariable Long serviceId) {
    Booking booking = bookingService.createBooking(customerId, serviceId);
    return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PostMapping("/{customerId}/review/{serviceId}")
    public ResponseEntity<Review> writeReview(
        @PathVariable Long customerId,
        @PathVariable Long serviceId,
        @RequestBody Review review) {
    //  review.setCustomerId(customerId);
    //  review.setBookingId(bookingId);
    Review savedReview = reviewService.createReview( customerId, serviceId, review.getComment(), review.getRating());
    return new ResponseEntity<>(savedReview, HttpStatus.CREATED);

    
}
}
