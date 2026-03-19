package com.sp26.team8.controller;

import com.sp26.team8.entity.Service;
import com.sp26.team8.entity.Service.Service;

import com.sp26.team8.service.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service createdService = serviceService.createService(service);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices(@RequestParam(required = false) BoxStatus status,
            @RequestParam(required = false) Season season, @RequestParam(required = false) BigDecimal maxPrice) {
        List<Service> services = serviceService.filterServices(status, season, maxPrice);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Optional<Service> service = serviceService.getServiceById(id);
        return service.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Service>> getServicesByProviderId(@PathVariable Long providerId) {
        List<Service> services = serviceService.getServicesByProviderId(providerId);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Service>> getServicesByStatus(@PathVariable String status) {
        List<Service> services = serviceService.getServicesByStatus(status);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service serviceDetails) {
        try {
            Service updatedService = serviceService.updateService(id, serviceDetails);
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
