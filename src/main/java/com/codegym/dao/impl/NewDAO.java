package com.codegym.dao.impl;

import com.codegym.dao.INewDAO;
import com.codegym.mapper.NewMapper;
import com.codegym.model.NewModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	
	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(), new NewMapper());
	}
}
