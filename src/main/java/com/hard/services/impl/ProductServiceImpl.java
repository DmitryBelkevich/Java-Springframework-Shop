package com.hard.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hard.dao.ProductDao;
import com.hard.models.Product;
import com.hard.services.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("productDatabaseDao")
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		
	}
	
	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}
	
	@Override
	public Product getById(long id) {
		return productDao.getById(id);
	}
	
	@Override
	public void add(Product model) {
		productDao.add(model);
	}
	
	@Override
	public void update(Product model) {
		productDao.update(model);
	}
	
	@Override
	public void delete(Product model) {
		productDao.delete(model);
	}
}