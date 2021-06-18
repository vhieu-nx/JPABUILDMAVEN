package com.codegym.service;

import com.codegym.dto.CategoryDTO;
import com.codegym.dto.NewDTO;
import com.codegym.model.NewModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findById(Long id);


}
