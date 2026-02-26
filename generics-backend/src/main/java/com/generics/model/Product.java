package com.generics.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Double price;
    private String category;
    private Integer stock;
    private String size;
    private String packagingType;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
}