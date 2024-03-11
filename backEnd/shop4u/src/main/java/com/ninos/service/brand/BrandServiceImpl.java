package com.ninos.service.brand;

import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ninos.mapper.BrandMapper;
import com.ninos.model.dto.BrandDTO;
import com.ninos.model.entity.Brand;
import com.ninos.model.entity.Product;
import com.ninos.repository.BrandRepository;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;


    @Override
    public Page<BrandDTO> getAllBrands(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Brand> brandList = brandRepository.findAll(pageRequest);
        return new PageImpl<>(brandList.getContent().stream().map(brand -> brandMapper.brandEntityToDto(brand))
                .collect(Collectors.toList()), pageRequest, brandList.getTotalElements());
    }
}
