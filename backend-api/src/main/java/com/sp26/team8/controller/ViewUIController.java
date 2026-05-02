package com.sp26.team8.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.entity.Booking.BookingStatus;
import com.sp26.team8.entity.Customer;
import com.sp26.team8.entity.User;
import com.sp26.team8.service.BookingService;
import com.sp26.team8.service.CleaningServiceService;
import com.sp26.team8.service.CustomerService;
import com.sp26.team8.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewUIController {
    @Autowired
    private CleaningServiceService serviceService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
        public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        List<Booking> bookings = userId != null
                ? bookingService.getBookingsByUser(userId)
                : List.of();
        model.addAttribute("bookings", bookings);
        model.addAttribute("title", "Home");
        return "index";
    }

    @GetMapping("/booking")
    public String booking(@RequestParam Long serviceId, Model model) {
        model.addAttribute("serviceId", serviceId);
        model.addAttribute("title", "Booking");
        return "booking";
    }

    @PostMapping("/book")
    public String createBooking(@RequestParam Long serviceId, @RequestParam String startDate,
            @RequestParam String endDate, @RequestParam String address, Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("userId");
        if (customerId == null) {
        return "redirect:/login";
    }
        try {
            Booking booking = bookingService.createBooking(customerId, serviceId, LocalDateTime.parse(startDate),
                    LocalDateTime.parse(endDate), address);
            return "redirect:/confirmation?bookingId=" + booking.getBookingId();
        } catch (RuntimeException e) {
            model.addAttribute("error", "Invalid booking data");
            model.addAttribute("title", "Booking");
            return "booking";
        }
    }

    @GetMapping("/booking/cancel")
public String cancelBooking(@RequestParam Long bookingId, HttpSession session , Model model) {

    Long userId = (Long) session.getAttribute("userId");
    Booking booking = bookingService.findById(bookingId);
    if (booking == null || booking.getCustomer() == null || !booking.getCustomer().getUserId().equals(userId)) {
        return "redirect:/";
    }
    booking.setStatus(BookingStatus.CANCELLED);
    bookingService.save(booking);
    return "redirect:/my-bookings";
}

@GetMapping("/my-bookings")
public String myBookings(HttpSession session, Model model) {
    Long customerId = (Long) session.getAttribute("userId");
    if (customerId == null) {
        return "redirect:/login";
    }
     model.addAttribute("bookings", bookingService.findByCustomer(customerId)
    );
        model.addAttribute("title", "My Bookings");
    return "/my-bookings";
}

    @GetMapping("/confirmation")
    public String confirmation(@RequestParam Long bookingId, Model model) {
        Booking booking = bookingService.findById(bookingId);
         if (booking == null) {
        model.addAttribute("errorMessage", "Booking not found");
        return "error";
    }
        model.addAttribute("booking", booking);
        model.addAttribute("title", "Confirmation");
        return "confirmation";
    }

    @GetMapping("/reviews/new")
    public String reviewForm(@RequestParam Long bookingId, Model model) {
        Booking booking = bookingService.findById(bookingId);
        model.addAttribute("booking", booking);
        model.addAttribute("reviews", reviewService.getReviewsByBookingId(bookingId));
        model.addAttribute("title", "Submit Review");
        return "review";
    }

    @PostMapping("/reviews/save")
    public String saveReview(@RequestParam Long bookingId, @RequestParam int rating, @RequestParam String comment , Model model, HttpSession session) {
    
        Long customerId = (Long) session.getAttribute("userId");
        reviewService.createReview(customerId, bookingId, comment, rating);
        Booking booking = bookingService.findById(bookingId);
        booking.setStatus(BookingStatus.COMPLETED);
        bookingService.save(booking);
        model.addAttribute("title", "Submit Review");
        return "redirect:/reviews/new?bookingId=" + bookingId;
    }

    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("title", "Sign Up");
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String email, @RequestParam String phone,
            @RequestParam String address, @RequestParam String password , Model model) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phone);
        customer.setAddress(address);
        customer.setPasswordHash(password);
        customer.setRole(User.UserRole.CUSTOMER);
        customer.setStatus(User.UserStatus.ACTIVE);
        customerService.createCustomer(customer);
        model.addAttribute("title", "Login");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        
        Customer customer = customerService.getCustomerByEmail(email);
        if (customer == null || !customer.getPasswordHash().equals(password)) {
            model.addAttribute("error", "Invalid credentials");
            model.addAttribute("title", "Login");
            return "login";
        }
        session.setAttribute("userId", customer.getUserId());
        return "redirect:/";
    }

    
    @GetMapping("/providers")
    public String searchProviders(@RequestParam(required = false) String keyword,
            @RequestParam(required = false) BigDecimal maxPrice, Model model) {
        if ((keyword == null || keyword.isEmpty()) && maxPrice == null) {
            model.addAttribute("services", serviceService.findAll());
        } else if (maxPrice != null) {
            model.addAttribute("services", serviceService.searchByMaxPrice(maxPrice));
        } else {
            model.addAttribute("services", serviceService.searchByTitle(keyword));
        }
        model.addAttribute("title", "Cleaning Services");
        return "providers";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
         if (userId == null) {
        return "redirect:/login";
    }
        Customer customer = customerService.getCustomerById(userId).orElse(null);
        if (customer == null) {
        model.addAttribute("errorMessage", "Customer not found with ID: " + userId);
            model.addAttribute("title", "Error");
    }
        model.addAttribute("customer", customer);
        model.addAttribute("title", "Profile");
        
        return "profile";
    }


    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam String name, @RequestParam String phone, @RequestParam String address,
            @RequestParam String email, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        Customer customer = customerService.getCustomerById(userId).orElseThrow();
        customer.setName(name);
        customer.setPhoneNumber(phone);
        customer.setAddress(address);
        customer.setEmail(email);
        customerService.createCustomer(customer);
        model.addAttribute("title", "Profile");
        return "redirect:/profile";
    }

    @GetMapping("/logout") public String logout(HttpSession session, Model model) { 
        session.invalidate(); 
        model.addAttribute("title", "Logout"); 
    return "redirect:/login"; 

    }
}