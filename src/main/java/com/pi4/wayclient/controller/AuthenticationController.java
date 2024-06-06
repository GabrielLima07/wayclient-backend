package com.pi4.wayclient.controller;

import com.pi4.wayclient.dto.AuthenticationDTO;
import com.pi4.wayclient.dto.LoginResponseDTO;
import com.pi4.wayclient.dto.SignUpDTO;
import com.pi4.wayclient.model.*;
import com.pi4.wayclient.repository.AdminRepository;
import com.pi4.wayclient.repository.CustomerRepository;
import com.pi4.wayclient.repository.EmployeeRepository;
import com.pi4.wayclient.repository.UserRepository;
import com.pi4.wayclient.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody @Valid SignUpDTO data) {
        if(userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        if (data.role() == UserRole.ADMIN) {
            Admin newAdmin = new Admin(data.email(), data.name(), encryptedPassword, data.role());
            this.adminRepository.save(newAdmin);
        } else if (data.role() == UserRole.EMPLOYEE) {
            Employee newEmployee = new Employee(data.email(), data.name(), encryptedPassword, data.role());
            this.employeeRepository.save(newEmployee);
        } else {
            Customer newCustomer = new Customer(data.email(), data.name(), encryptedPassword, data.role());
            this.customerRepository.save(newCustomer);
        }

        return ResponseEntity.ok().build();
    }
}
