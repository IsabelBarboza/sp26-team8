package com.sp26.team8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.CleaningService;
import com.sp26.team8.service.CleaningServiceService;

import jakarta.persistence.Column;

@RestController
@RequestMapping("/api/services")
public class CleaningServiceController {

    @Autowired
    private CleaningServiceService serviceService;

   @Column
    private String imageUrl;
    
    @GetMapping
    public List<CleaningService> getAllServices() {
        return serviceService.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CleaningService> getServiceById(@PathVariable Long id) {
        try {
            CleaningService service =  serviceService.findById(id);
            return new ResponseEntity<>(service, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    

    
    @PostMapping
    public ResponseEntity<CleaningService> createService(@RequestBody CleaningService service) {
        CleaningService created = serviceService.save(service);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CleaningService> updateService(@PathVariable Long id,
                                                         @RequestBody CleaningService serviceDetails) {
        try {
            CleaningService service = serviceService.findById(id);
            if (serviceDetails.getTitle() != null) service.setTitle(serviceDetails.getTitle());
            if (serviceDetails.getDescription() != null) service.setDescription(serviceDetails.getDescription());
            if (serviceDetails.getPrice() != null) service.setPrice(serviceDetails.getPrice());
            if (serviceDetails.getStatus() != null) service.setStatus(serviceDetails.getStatus());

            CleaningService updated = serviceService.save(service);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
