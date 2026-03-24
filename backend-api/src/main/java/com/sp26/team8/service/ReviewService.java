package com.sp26.team8.service;
import java.time.LocalDateTime;
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
        review.setComment(comment);
        review.setRating(rating);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
     }
    
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

}
/*
import com.sp26.team8.entity.Review;
import com.sp26.team8.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
    
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
    
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    
    public List<Review> getReviewsByBookingId(Long bookingId) {
        return reviewRepository.findByBookingId(bookingId);
    }
    
    public Review updateReview(Long id, Review reviewDetails) {
        return reviewRepository.findById(id).map(review -> {
            review.setRating(reviewDetails.getRating());
            review.setComment(reviewDetails.getComment());
            review.setReplyText(reviewDetails.getReplyText());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found"));
    }
    
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
*/