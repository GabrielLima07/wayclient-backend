package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.Admin;
import com.pi4.wayclient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Admin post_admin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping
    public List<Admin> get_admin() {
        return adminService.retrieveAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> get_admin(@PathVariable UUID id) {
        return adminService.retrieveAdminById(id);
    }

    @PutMapping
    public Admin put_admin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void delete_admin(@PathVariable UUID id) {
        adminService.deleteAdmin(id);
    }

}
