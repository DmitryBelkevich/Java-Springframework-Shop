package com.hard.dao.impl;

import org.springframework.stereotype.Repository;

import com.hard.dao.ProductDao;
import com.hard.models.Product;

@Repository("productDatabaseDao")
public class ProductDatabaseDaoImpl extends AbstractDatabaseDaoImpl<Product> implements ProductDao {
	public ProductDatabaseDaoImpl() {
		
	}
}