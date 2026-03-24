package com.sp26.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp26.team8.entity.CleaningService;

@Repository
public interface CleaningServiceRepository extends JpaRepository<CleaningService, Long> {}
/*
import com.sp26.team8.entity.CleaningService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<CleaningService, Long> {
    List<CleaningService> findByProviderProviderId(Long providerId);
    List<CleaningService> findByStatus(CleaningService.ServiceStatus status);
}
*/