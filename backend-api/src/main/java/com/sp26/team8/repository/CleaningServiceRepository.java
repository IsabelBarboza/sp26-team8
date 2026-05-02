package com.sp26.team8.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp26.team8.entity.CleaningService;

@Repository
public interface CleaningServiceRepository extends JpaRepository<CleaningService, Long> {

List<CleaningService> findByTitleContainingIgnoreCase(String keyword);

List<CleaningService> findByPriceLessThanEqual(BigDecimal price);
}
