package com.hard.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hard.dao.ProductDao;
import com.hard.models.Product;

@Repository("productFileDao")
public class ProductFileDaoImpl extends AbstractFileDaoImpl<Product> implements ProductDao {
	public ProductFileDaoImpl() {
		
	}
	
	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Product getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}