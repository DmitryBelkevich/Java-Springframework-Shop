package com.hard.dao;

import java.util.List;

import com.hard.models.Model;

public interface ModelDao<T extends Model> {
	public List<T> getAll();
	public T getById(long id);
	public void add(T model);
	public void update(T model);
	public void delete(T model);
}