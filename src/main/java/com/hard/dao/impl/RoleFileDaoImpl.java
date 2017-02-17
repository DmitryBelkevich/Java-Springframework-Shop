package com.hard.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hard.dao.RoleDao;
import com.hard.models.Role;

@Repository("roleFileDao")
public class RoleFileDaoImpl extends AbstractFileDaoImpl<Role> implements RoleDao {
	public RoleFileDaoImpl() {
		
	}
	
	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Role getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}