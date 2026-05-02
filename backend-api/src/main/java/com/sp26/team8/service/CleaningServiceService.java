package com.sp26.team8.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp26.team8.entity.CleaningService;
import com.sp26.team8.repository.CleaningServiceRepository;

@Service
public class CleaningServiceService {

    @Autowired
    private CleaningServiceRepository repository;

    public List<CleaningService> findAll() {
        return repository.findAll();
    }

    public CleaningService findById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public List<CleaningService> searchByTitle(String keyword) {
    return repository.findByTitleContainingIgnoreCase(keyword);
}
public List<CleaningService> searchByMaxPrice(BigDecimal price) {
        return repository.findByPriceLessThanEqual(price);
    }

    public CleaningService save(CleaningService service) {
        return repository.save(service);
    }
}
