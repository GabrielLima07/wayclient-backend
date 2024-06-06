package com.pi4.wayclient.dto;

import com.pi4.wayclient.model.UserRole;

public record SignUpDTO(String email, String name, String password, UserRole role) {
}
