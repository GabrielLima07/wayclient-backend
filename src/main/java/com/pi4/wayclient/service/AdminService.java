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
        Admin newAdmin = adminRepository.save(admin);
        return newAdmin;
    }

    public List<Admin> retrieveAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> retrieveAdminById(UUID id) {
        return adminRepository.findById(id);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(UUID id) {
        adminRepository.deleteById(id);
    }
}
