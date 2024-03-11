package com.ninos.service.category;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ninos.mapper.CategoryMapper;
import com.ninos.model.dto.CategoryDTO;
import com.ninos.model.entity.Category;
import com.ninos.repository.CategoryRepository;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public Page<CategoryDTO> getAllCategories(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> categoryList = categoryRepository.findAll(pageRequest);
        return new PageImpl<>(categoryList.getContent().stream().map(category -> categoryMapper.categoryEntityToDto(category))
                .collect(Collectors.toList()), pageRequest, categoryList.getTotalElements());

    }


}
