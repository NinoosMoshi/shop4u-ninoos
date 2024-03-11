package com.ninos.service.product;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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


//    @Override
//    public ProductDTO getProductById(Long productId) {
//        Optional<Product> product = productRepository.findById(productId);
//        if(product.isPresent()){
//          return productMapper.productEntityToDto(product.get());
//        }
//        return null;
//    }


    @Override
    public Page<ProductDTO> getAllProducts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productList = productRepository.findAll(pageRequest);
        return new PageImpl<>(productList.getContent().stream().map(product -> productMapper.productEntityToDto(product)).collect(Collectors.toList()), pageRequest, productList.getTotalElements());
    }


    @Override
    public Page<ProductDTO> getProductsByBrandId(Long id, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productsByBrandId = productRepository.findByBrandBrandId(id, pageRequest);
        return new PageImpl<>(productsByBrandId.getContent().stream().map(product -> productMapper.productEntityToDto(product)).collect(Collectors.toList()), pageRequest, productsByBrandId.getTotalElements());
    }


}
