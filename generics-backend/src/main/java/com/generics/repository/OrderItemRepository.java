package com.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generics.model.OrderItem;
import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    List<OrderItem> findByProductSellerId(UUID sellerId);
}