package com.ninos.service.product;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ninos.model.dto.ProductDTO;

public interface ProductService {

//     ProductDTO getProductById(Long productId);

     Page<ProductDTO> getAllProducts(int page, int size);

     Page<ProductDTO> getProductsByBrandId(Long id, int page, int size);

}
