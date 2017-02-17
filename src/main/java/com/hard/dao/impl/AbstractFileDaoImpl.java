package com.hard.dao.impl;

import java.util.List;

import com.hard.dao.accessors.FileDatasourceAccessor;
import com.hard.models.Model;

public abstract class AbstractFileDaoImpl<T extends Model> extends FileDatasourceAccessor {
	public List<T> getAll() {
		// TODO method stub
		return null;
	}
	
	public T getById(long id) {
		// TODO method stub
		return null;
	}
	
	public void add(T model) {
		// TODO method stub
	}
	
	public void update(T model) {
		// TODO method stub
	}
	
	public void delete(T model) {
		// TODO method stub
	}
}