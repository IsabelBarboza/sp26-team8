package com.sp26.team8.service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.entity.Booking.BookingStatus;
import com.sp26.team8.entity.CleaningService;
import com.sp26.team8.entity.Customer;
import com.sp26.team8.repository.BookingRepository;
import com.sp26.team8.repository.CleaningServiceRepository;
import com.sp26.team8.repository.CustomerRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CleaningServiceRepository serviceRepository;

 
    public Booking createBooking(Long customerId,
                                 Long serviceId,
                                 LocalDateTime startDate,
                                 LocalDateTime endDate,
                                 String address) {
                                          

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        CleaningService service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
          
        if (endDate.isBefore(startDate) || endDate.isEqual(startDate)) {
            throw new RuntimeException("Invalid time range");
        }

       long minutes = Duration.between(startDate, endDate).toMinutes();
         double hours = minutes / 60.0;
        double totalprice = service.getPrice().doubleValue() * hours;             
        
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setService(service);
        booking.setAddress(address);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setHours(hours);
        booking.setTotalPrice(totalprice);
         booking.setStatus(BookingStatus.ACTIVE);        
        return bookingRepository.save(booking);
    }

public Booking findById(Long bookingId) {
    return bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
}

public Booking save(Booking booking) {
    return bookingRepository.save(booking);
}
public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByCustomer_UserId(userId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public List<Booking> findByCustomer(Long userId) {
        return bookingRepository.findByCustomer_UserId(userId);
    }
}
