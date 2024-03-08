package com.ninos.service.product;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ninos.mapper.ProductMapper;
import com.ninos.model.dto.ProductDTO;
import com.ninos.model.entity.Product;
import com.ninos.repository.ProductRepository;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductDTO getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
          return productMapper.productEntityToDto(product.get());
        }
        return null;
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> productMapper.productEntityToDto(product)).collect(Collectors.toList());
    }





}
