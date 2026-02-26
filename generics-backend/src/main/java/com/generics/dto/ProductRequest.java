package com.generics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Double price;
    private String category;
    private Integer stock;
    private String size;
    private String packagingType;
}