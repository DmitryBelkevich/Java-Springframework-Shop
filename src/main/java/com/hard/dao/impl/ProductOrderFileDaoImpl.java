package com.hard.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hard.dao.ProductOrderDao;
import com.hard.models.ProductOrder;

@Repository("productOrderFileDao")
public class ProductOrderFileDaoImpl extends AbstractFileDaoImpl<ProductOrder> implements ProductOrderDao {
	public ProductOrderFileDaoImpl() {
		
	}
	
	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ProductOrder> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ProductOrder getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}