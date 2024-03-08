package com.ninos.model.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long productId;
    private String sku;
    private String title;
    private String description;
    private double unitPrice;
    private String imageUrl;

    private long brandId;
    private long categoryId;
    private String categoryName;
    private String brandName;


}
