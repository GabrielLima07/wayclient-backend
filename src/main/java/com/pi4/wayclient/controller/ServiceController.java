package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.ServiceEntity;
import com.pi4.wayclient.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("service")
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<ServiceEntity> postService(@RequestBody ServiceEntity serviceEntity) {
        ServiceEntity newService = serviceService.createService(serviceEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newService);
    }

    @GetMapping
    public ResponseEntity<List<ServiceEntity>> getServices() {
        List<ServiceEntity> serviceEntityList = serviceService.retrieveServices();
        return ResponseEntity.status(HttpStatus.OK).body(serviceEntityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ServiceEntity>> getServiceById(@PathVariable UUID id) {
        Optional<ServiceEntity> serviceEntity = serviceService.retrieveServiceById(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateService(@PathVariable UUID id, @RequestBody ServiceEntity serviceEntity) {
        ServiceEntity updatedService = serviceService.updateService(id, serviceEntity);
        return ResponseEntity.status(HttpStatus.OK).body(updatedService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable UUID id) {
        boolean deleted = serviceService.deleteService(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
