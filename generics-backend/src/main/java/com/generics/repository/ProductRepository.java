package com.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generics.model.Product;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findBySellerId(UUID sellerId);
}