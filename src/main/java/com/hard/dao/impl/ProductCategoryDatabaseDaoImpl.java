package com.hard.dao.impl;

import org.springframework.stereotype.Repository;

import com.hard.dao.ProductCategoryDao;
import com.hard.models.ProductCategory;

@Repository("productCategoryDatabaseDao")
public class ProductCategoryDatabaseDaoImpl extends AbstractDatabaseDaoImpl<ProductCategory> implements ProductCategoryDao {
	public ProductCategoryDatabaseDaoImpl() {
		
	}
}