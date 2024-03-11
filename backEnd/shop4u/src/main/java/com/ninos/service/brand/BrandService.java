package com.ninos.service.brand;

import org.springframework.data.domain.Page;

import com.ninos.model.dto.BrandDTO;

public interface BrandService {

    Page<BrandDTO> getAllBrands(int page, int size);

}
