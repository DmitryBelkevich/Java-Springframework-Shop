package com.hard.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hard.dao.ProductCategoryDao;
import com.hard.models.ProductCategory;
import com.hard.services.ProductCategoryService;

@Service("productCategoryService")
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	@Qualifier("productCategoryDatabaseDao")
	private ProductCategoryDao productCategoryDao;
	
	public ProductCategoryServiceImpl() {
		
	}
	
	@Override
	public List<ProductCategory> getAll() {
		return productCategoryDao.getAll();
	}
	
	@Override
	public ProductCategory getById(long id) {
		return productCategoryDao.getById(id);
	}
	
	@Override
	public void add(ProductCategory model) {
		productCategoryDao.add(model);
	}
	
	@Override
	public void update(ProductCategory model) {
		productCategoryDao.update(model);
	}
	
	@Override
	public void delete(ProductCategory model) {
		productCategoryDao.delete(model);
	}
}