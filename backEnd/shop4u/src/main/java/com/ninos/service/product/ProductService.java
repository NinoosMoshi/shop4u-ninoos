package com.ninos.service.product;

import java.util.List;

import com.ninos.model.dto.ProductDTO;

public interface ProductService {

     ProductDTO getProductById(Long productId);
     List<ProductDTO> getAllProducts();

}
