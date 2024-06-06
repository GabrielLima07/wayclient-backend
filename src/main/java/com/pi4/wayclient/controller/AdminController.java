package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.Admin;
import com.pi4.wayclient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Admin> post_admin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAdmin);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> get_admin() {
        List<Admin> adminList = adminService.retrieveAdmins();
        return ResponseEntity.status(HttpStatus.OK).body(adminList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Admin>> get_admin(@PathVariable UUID id) {
        Optional<Admin> admin = adminService.retrieveAdminById(id);
        return ResponseEntity.status(HttpStatus.OK).body(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> put_admin(@PathVariable UUID id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable UUID id) {
        boolean deleted = adminService.deleteAdmin(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
