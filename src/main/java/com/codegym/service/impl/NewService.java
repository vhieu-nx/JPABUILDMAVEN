package com.codegym.service.impl;

import com.codegym.converter.CategoryConverter;
import com.codegym.converter.NewConverter;
import com.codegym.dto.CategoryDTO;
import com.codegym.dto.NewDTO;
import com.codegym.entity.CategoryEntity;
import com.codegym.entity.NewEntity;
import com.codegym.repository.CategoryRepository;
import com.codegym.repository.NewRepository;
import com.codegym.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository repository;
	@Autowired
	private NewConverter newConverter;


	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = repository.findAll(pageable).getContent();
		for (NewEntity item: entities
			 ) {
			NewDTO newDTO = newConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) repository.count();
	}

	@Override
	public NewDTO findById(Long id) {
		NewEntity entity = repository.findOne(id);
		return newConverter.toDto(entity);
	}


}
