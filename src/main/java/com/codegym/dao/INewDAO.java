package com.codegym.dao;

import com.codegym.model.NewModel;

import java.util.List;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}
