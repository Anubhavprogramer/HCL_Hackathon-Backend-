package com.generics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.generics.repository.*;
import com.generics.model.*;
import com.generics.dto.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    private final OrderItemRepository orderItemRepo;
    private final PasswordEncoder encoder;


    public void registerSeller(RegisterRequest request) {

        User seller = new User();
        seller.setName(request.getName());
        seller.setEmail(request.getEmail());
        seller.setPassword(encoder.encode(request.getPassword()));
        seller.setRole(Role.SELLER);

        userRepo.save(seller);
    }


    public Product addProduct(ProductRequest request, UUID sellerId) {

        User seller = userRepo.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setStock(request.getStock());
        product.setSize(request.getSize());
        product.setPackagingType(request.getPackagingType());
        product.setSeller(seller);

        return productRepo.save(product);
    }

    public List<Product> getSellerProducts(UUID sellerId) {
        return productRepo.findBySellerId(sellerId);
    }


    public List<OrderItem> getSellerOrders(UUID sellerId) {
        return orderItemRepo.findByProductSellerId(sellerId);
    }
}