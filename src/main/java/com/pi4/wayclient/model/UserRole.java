package com.pi4.wayclient.model;

public enum UserRole {
    ADMIN("admin"),
    EMPLOYEE("employee"),
    CUSTOMER("customer");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
