package com.pi4.wayclient.service;

import com.pi4.wayclient.model.Admin;
import com.pi4.wayclient.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> retrieveAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> retrieveAdminById(UUID id) {
        return adminRepository.findById(id);
    }

    public Admin updateAdmin(UUID id, Admin newAdmin) {
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setName((newAdmin.getName() == null) ? admin.getName() : newAdmin.getName());
                    admin.setEmail((newAdmin.getEmail() == null) ? admin.getEmail() : newAdmin.getEmail());
                    admin.setPassword((newAdmin.getPassword() == null) ? admin.getPassword() : newAdmin.getPassword());
                    admin.setDepartments((newAdmin.getDepartments() == null) ? admin.getDepartments() : newAdmin.getDepartments());
                    admin.setActivities((newAdmin.getActivities() == null) ? admin.getActivities() : newAdmin.getActivities());
                    return adminRepository.save(admin);
                })
                .orElseGet(() -> {
                    return adminRepository.save(newAdmin);
                });
    }

    public boolean deleteAdmin(UUID id) {
        try {
            adminRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
