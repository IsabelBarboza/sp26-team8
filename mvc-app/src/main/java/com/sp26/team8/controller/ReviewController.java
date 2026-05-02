package com.sp26.team8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.Review;
import com.sp26.team8.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review create(@RequestParam Long customerId,
                         @RequestParam Long bookingId,
                         @RequestParam String comment,
                         @RequestParam int rating) {

        return reviewService.createReview(customerId, bookingId, comment, rating);
    }
}
