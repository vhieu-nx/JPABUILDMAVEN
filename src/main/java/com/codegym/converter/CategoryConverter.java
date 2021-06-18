package com.codegym.converter;

import com.codegym.dto.CategoryDTO;
import com.codegym.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toDTO(CategoryEntity entity){
        CategoryDTO result = new CategoryDTO();
        result.setId(entity.getId());
        result.setCode(entity.getCode());
        result.setName(entity.getName());
        return  result;
    }
    public CategoryEntity toEntity(CategoryDTO entity){
        CategoryEntity result = new CategoryEntity();
        result.setCode(entity.getCode());
        result.setName(entity.getName());
        return result;
    }
}
