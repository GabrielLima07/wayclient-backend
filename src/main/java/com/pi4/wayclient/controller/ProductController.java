package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.Employee;
import com.pi4.wayclient.model.Product;
import com.pi4.wayclient.service.EmployeeService;
import com.pi4.wayclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {this.productService = productService;}

    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable UUID id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getAllProduct();
    }

    @PutMapping("/{id}")
    public Product putProduct(@PathVariable UUID id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable UUID id) {
        try {
            productService.deleteProduct(id);
            return "Employee with ID " + id + " deleted successfully";
        } catch (Exception e) {
            return "Failed to delete employee with ID " + id + ": " + e.getMessage();
        }
    }

}
