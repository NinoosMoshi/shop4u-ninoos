package com.ninos.controller;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.dto.BrandDTO;
import com.ninos.model.dto.CategoryDTO;
import com.ninos.model.dto.ProductDTO;
import com.ninos.model.entity.Brand;
import com.ninos.model.entity.Category;
import com.ninos.repository.BrandRepository;
import com.ninos.repository.CategoryRepository;
import com.ninos.service.brand.BrandService;
import com.ninos.service.category.CategoryService;
import com.ninos.service.product.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/shop")
public class ProductController {


    private final ProductService productService;
    private final BrandService brandService;
    private final CategoryService categoryService;


    @GetMapping("/products")
    public ResponseEntity<Page<ProductDTO>> getProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                                        @RequestParam(name = "size", defaultValue = "20") int size){
        Page<ProductDTO> allProducts = productService.getAllProducts(page, size);
        return ResponseEntity.ok(allProducts);
    }


    // http://localhost:8080/api/shop/brands
    @GetMapping("/brands")
    public Page<BrandDTO> getBrands(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "10") int size){
        return brandService.getAllBrands(page, size);
    }


    // http://localhost:8080/api/shop/categories
    @GetMapping("/categories")
    public Page<CategoryDTO> getCategories(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size){
        return categoryService.getAllCategories(page, size);
    }

    // http://localhost:8080/api/shop?id=<brandId>
    @GetMapping()
    public Page<ProductDTO> productsByBrandId(@RequestParam Long id,
                                              @RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "size", defaultValue = "10") int size){
        return productService.getProductsByBrandId(id, page, size);
    }




}
