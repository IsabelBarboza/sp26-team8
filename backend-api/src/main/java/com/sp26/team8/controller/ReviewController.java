package com.sp26.team8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.Review;
import com.sp26.team8.service.ReviewService;

@RestController
@RequestMapping("/api/customers")
public class ReviewController {
    

    @Autowired
    private ReviewService reviewService;
    @PostMapping("/{customerId}/review/{bookingId}")
    public ResponseEntity<Review> writeReview(
            @PathVariable Long customerId,
            @PathVariable Long bookingId,
            @RequestBody Review review) {
    try {
            Review saved = reviewService.createReview(customerId, bookingId,
                review.getComment(), review.getRating());
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }          

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}
/* 
import com.sp26.team8.entity.Review;
import com.sp26.team8.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Review>> getReviewsByBookingId(@PathVariable Long bookingId) {
        List<Review> reviews = reviewService.getReviewsByBookingId(bookingId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        try {
            Review updatedReview = reviewService.updateReview(id, reviewDetails);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
*/