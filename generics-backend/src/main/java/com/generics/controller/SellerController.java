package com.generics.controller;

import org.springframework.web.bind.annotation.*;
import com.generics.service.SellerService;
import com.generics.dto.*;
import com.generics.model.Product;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        sellerService.registerSeller(request);
        return "Seller registered successfully";
    }

    @PostMapping("/products/{sellerId}")
    public Product addProduct(
            @RequestBody ProductRequest request,
            @PathVariable UUID sellerId) {

        return sellerService.addProduct(request, sellerId);
    }

    @GetMapping("/products/{sellerId}")
    public List<Product> getProducts(@PathVariable UUID sellerId) {
        return sellerService.getSellerProducts(sellerId);
    }

    @GetMapping("/orders/{sellerId}")
    public Object getOrders(@PathVariable UUID sellerId) {
        return sellerService.getSellerOrders(sellerId);
    }
}