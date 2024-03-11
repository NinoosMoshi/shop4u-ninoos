package com.ninos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ninos.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

      Page<Product> findByBrandBrandId(@Param("id") Long id, Pageable pageable);
}
