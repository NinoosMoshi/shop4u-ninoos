package com.ninos.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ninos.model.dto.ProductDTO;
import com.ninos.model.entity.Product;

@Service
public class ProductMapper {

    public Product productDtoToEntity(ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }


    public ProductDTO productEntityToDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryId(product.getCategory().getCategoryId());
        productDTO.setBrandId(product.getBrand().getBrandId());
        productDTO.setCategoryName(product.getCategory().getCategoryName());
        productDTO.setBrandName(product.getBrand().getBrandName());
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }


}
