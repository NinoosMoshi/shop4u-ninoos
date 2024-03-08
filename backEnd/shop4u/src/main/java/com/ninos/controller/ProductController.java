package com.ninos.controller;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.dto.ProductDTO;
import com.ninos.model.entity.Brand;
import com.ninos.model.entity.Category;
import com.ninos.repository.BrandRepository;
import com.ninos.repository.CategoryRepository;
import com.ninos.service.product.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/shop")
public class ProductController {

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductService productService;


    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryRepository.findAll();
        if(categories != null){
            return ResponseEntity.ok(categories);
        } else{
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getBrands(){
        List<Brand> brands = brandRepository.findAll();
        if(brands != null){
            return ResponseEntity.ok(brands);
        } else{
            return ResponseEntity.noContent().build();
        }
    }


//    @GetMapping("/products")
//    public ResponseEntity<List<ProductDTO>> getProducts(){
//        List<ProductDTO> allProducts = productService.getAllProducts();
//        return ResponseEntity.ok(allProducts);
//    }
    @GetMapping("/products")
    public ResponseEntity<Page<ProductDTO>> getProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                                        @RequestParam(name = "size", defaultValue = "20") int size){
        Page<ProductDTO> allProducts = productService.getAllProducts(page, size);
        return ResponseEntity.ok(allProducts);
    }




}
