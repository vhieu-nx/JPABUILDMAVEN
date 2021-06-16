package com.codegym.service.impl;

import com.codegym.entity.NewEntity;
import com.codegym.model.NewModel;
import com.codegym.repository.NewRepository;
import com.codegym.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository repository;
	
	@Override
	public List<NewModel> findAll() {
		List<NewModel> models = new ArrayList<>();
		List<NewEntity> entities = repository.findAll();
		for (NewEntity item: entities
			 ) {
			NewModel newModel = new NewModel();
			newModel.setTitle(item.getTitle());
			newModel.setThumbnail(item.getThumbnail());
			newModel.setShortDescription(item.getShortDescription());
			newModel.setContent(item.getContent());
			models.add(newModel);
		}
		return models;
	}
}
