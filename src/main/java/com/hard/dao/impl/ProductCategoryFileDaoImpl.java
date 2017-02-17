package com.hard.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hard.dao.ProductCategoryDao;
import com.hard.models.ProductCategory;

@Repository("productCategoryFileDao")
public class ProductCategoryFileDaoImpl extends AbstractFileDaoImpl<ProductCategory> implements ProductCategoryDao {
	public ProductCategoryFileDaoImpl() {
		
	}
	
	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ProductCategory> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ProductCategory getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}