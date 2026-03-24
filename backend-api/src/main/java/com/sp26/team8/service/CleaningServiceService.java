package com.sp26.team8.service;

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

    public CleaningService save(CleaningService service) {
        return repository.save(service);
    }
}
/* 
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp26.team8.entity.CleaningService;
import com.sp26.team8.entity.CleaningService.ServiceStatus;
import com.sp26.team8.repository.ServiceRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public CleaningService createService(CleaningService service) {
        return serviceRepository.save(service);
    }

    public Optional<CleaningService> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public List<CleaningService> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<CleaningService> getServicesByProviderId(Long providerId) {
        return serviceRepository.findByProviderProviderId(providerId);
    }

    public List<CleaningService> getServiceByStatus(String status) {
        return serviceRepository.findByStatus(CleaningService.ServiceStatus.valueOf(status));
    }

    public CleaningService updateService(Long id, CleaningService serviceDetails) {
        return serviceRepository.findById(id).map(service -> {
            service.setTitle(serviceDetails.getTitle());
            service.setDescription(serviceDetails.getDescription());
            service.setPrice(serviceDetails.getPrice());
            service.setStatus(serviceDetails.getStatus());
            return serviceRepository.save(service);
        }).orElseThrow(() -> new RuntimeException("Services not found"));
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }


   
}
*/