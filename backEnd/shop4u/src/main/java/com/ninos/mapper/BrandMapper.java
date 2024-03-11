package com.ninos.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ninos.model.dto.BrandDTO;
import com.ninos.model.entity.Brand;

@Service
public class BrandMapper {

    public Brand brandDtoToEntity(BrandDTO brandDTO){
        Brand brand = new Brand();
        BeanUtils.copyProperties(brand,brand);
        return brand;
    }


    public BrandDTO brandEntityToDto(Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        BeanUtils.copyProperties(brand, brandDTO);
        return brandDTO;
    }

}
