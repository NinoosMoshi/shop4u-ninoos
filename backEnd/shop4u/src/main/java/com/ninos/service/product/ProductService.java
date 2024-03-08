package com.ninos.service.product;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ninos.model.dto.ProductDTO;

public interface ProductService {

     ProductDTO getProductById(Long productId);

//     List<ProductDTO> getAllProducts();
     Page<ProductDTO> getAllProducts(int page, int size);

}
