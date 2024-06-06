package com.pi4.wayclient.service;

import com.pi4.wayclient.model.ServiceEntity;
import com.pi4.wayclient.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceEntity createService(ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }

    public List<ServiceEntity> retrieveServices() {
        return serviceRepository.findAll();
    }

    public Optional<ServiceEntity> retrieveServiceById(UUID id) {
        return serviceRepository.findById(id);
    }

    public ServiceEntity updateService(UUID id, ServiceEntity updatedService) {
        return serviceRepository.findById(id)
                .map(service -> {
                    updatedService.setDescription((updatedService.getDescription() == null) ? service.getDescription() : updatedService.getDescription());
                    return serviceRepository.save(service);
                })
                .orElseGet(() -> serviceRepository.save(updatedService));
    }

    public boolean deleteService(UUID id) {
        try {
            serviceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
