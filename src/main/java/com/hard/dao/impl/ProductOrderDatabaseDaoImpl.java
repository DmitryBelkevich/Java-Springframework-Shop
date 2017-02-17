package com.hard.dao.impl;

import org.springframework.stereotype.Repository;

import com.hard.dao.ProductOrderDao;
import com.hard.models.ProductOrder;

@Repository("productOrderDatabaseDao")
public class ProductOrderDatabaseDaoImpl extends AbstractDatabaseDaoImpl<ProductOrder> implements ProductOrderDao {
	public ProductOrderDatabaseDaoImpl() {
		
	}
}