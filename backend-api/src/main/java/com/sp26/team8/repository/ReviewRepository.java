package com.sp26.team8.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sp26.team8.entity.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByOrderByReviewIdDesc();
  List<Review> findByBooking_BookingId(Long bookingId);
}
