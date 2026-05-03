package com.sp26.team8.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp26.team8.entity.Booking;
import com.sp26.team8.entity.Review;
import com.sp26.team8.repository.BookingRepository;
import com.sp26.team8.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Review createReview(Long customerId, Long bookingId, String comment, Integer rating) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        
        if (!booking.getCustomer().getUserId().equals(customerId)) {
            throw new RuntimeException("Booking does not belong to customer");
        }

        Review review = new Review();
        review.setCustomer(booking.getCustomer());
        review.setService(booking.getService());
        review.setBooking(booking);
        review.setComment(comment);
        review.setRating(rating);
        

        return reviewRepository.save(review);
     }
    public List<Review> getReviewsByBookingId(Long bookingId) {
    return reviewRepository.findByBooking_BookingId(bookingId);
} 

    public List<Review> getAllReviews() {
         return reviewRepository.findAllByOrderByReviewIdDesc();
        }
    public List<Review> getReviewsByServiceId(Long serviceId) {
        return reviewRepository.findByService_ServiceId(serviceId); 
    }

}
