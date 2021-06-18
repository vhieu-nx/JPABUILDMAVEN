package com.codegym.service.impl;

import com.codegym.converter.CategoryConverter;
import com.codegym.dto.CategoryDTO;
import com.codegym.entity.CategoryEntity;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryConverter categoryConverter;
    @Override
    public Map<String,String> findAll() {
        Map<String,String> result = new HashMap<>();
//        List<CategoryDTO> result = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity cate: entities
        ) {
//            CategoryDTO categoryDTO = categoryConverter.toDTO(cate);
//            result.add(categoryDTO);
            result.put(cate.getCode(), cate.getName());
        }
        return result;
    }
}
