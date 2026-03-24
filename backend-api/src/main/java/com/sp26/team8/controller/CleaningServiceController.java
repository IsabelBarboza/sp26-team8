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

@RestController
@RequestMapping("/api/services")
public class CleaningServiceController {

    @Autowired
    private CleaningServiceService serviceService;

   
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
/* 
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp26.team8.entity.CleaningService;
import com.sp26.team8.service.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<CleaningService> createService(@RequestBody CleaningService service) {
        CleaningService created = serviceService.createService(service);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CleaningService>> getAllServices( @RequestParam(required = false) BigDecimal maxPrice) {
        List<CleaningService> list = serviceService.filterServices(null,maxPrice);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CleaningService> getServiceById(@PathVariable Long id) {
        Optional<CleaningService> service = serviceService.getServiceById(id);
        return service.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<CleaningService>> getServicesByProviderId(@PathVariable Long providerId) {
        List<CleaningService> services = serviceService.getServicesByProviderId(providerId);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<CleaningService>> getServicesByStatus(@PathVariable CleaningService.ServiceStatus status) {
        List<CleaningService> services = serviceService.getServiceByStatus(status.name());
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CleaningService> updateService(@PathVariable Long id, @RequestBody CleaningService serviceDetails) {
        try {
            CleaningService updatedService = serviceService.updateService(id, serviceDetails);
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
*/