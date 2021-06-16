package com.codegym.service.impl;

import com.codegym.dto.NewDTO;
import com.codegym.entity.NewEntity;
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
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = repository.findAll(pageable).getContent();
		for (NewEntity item: entities
			 ) {
			NewDTO newDTO = new NewDTO();
			newDTO.setTitle(item.getTitle());
			newDTO.setThumbnail(item.getThumbnail());
			newDTO.setShortDescription(item.getShortDescription());
			newDTO.setContent(item.getContent());
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) repository.count();
	}
}
