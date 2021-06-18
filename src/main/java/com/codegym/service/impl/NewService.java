package com.codegym.service.impl;

import com.codegym.converter.NewConverter;
import com.codegym.dto.NewDTO;
import com.codegym.entity.CategoryEntity;
import com.codegym.entity.NewEntity;
import com.codegym.repository.CategoryRepository;
import com.codegym.repository.NewRepository;
import com.codegym.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository repository;
	@Autowired
	private NewConverter newConverter;
	@Autowired
	private CategoryRepository categoryRepository;
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

	@Override
	@Transactional
	public NewDTO insert(NewDTO newDTO) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		NewEntity newEntity = newConverter.toEntity(newDTO);
		newEntity.setCategoryEntity(categoryEntity);
		return newConverter.toDto(repository.save(newEntity));
	}

	@Override
	@Transactional
	public NewDTO update(NewDTO updateNew) {
		NewEntity oldNew = repository.findOne(updateNew.getId());
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(updateNew.getCategoryCode());
		oldNew.setCategoryEntity(categoryEntity);
		NewEntity newEntity = newConverter.toEntity(oldNew,updateNew);

//		oldNew.setTitle(updateNew.getTitle());
//		oldNew.setContent(updateNew.getContent());
//		oldNew.setShortDescription(updateNew.getShortDescription());

		return newConverter.toDto(repository.save(newEntity));
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if (dto.getId() != null){
			NewEntity oldNew = repository.findOne(dto.getId());
			oldNew.setCategoryEntity(categoryEntity);
			newEntity = newConverter.toEntity(oldNew,dto);
		}else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategoryEntity(categoryEntity);
		}
		return newConverter.toDto(repository.save(newEntity));
	}


}
