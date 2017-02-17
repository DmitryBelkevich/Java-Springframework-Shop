package com.hard.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hard.dao.RoleDao;
import com.hard.models.Role;
import com.hard.services.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	@Qualifier("roleDatabaseDao")
	private RoleDao roleDao;
	
	public RoleServiceImpl() {
		
	}
	
	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}
	
	@Override
	public Role getById(long id) {
		return roleDao.getById(id);
	}
	
	@Override
	public void add(Role model) {
		roleDao.add(model);
	}
	
	@Override
	public void update(Role model) {
		roleDao.update(model);
	}
	
	@Override
	public void delete(Role model) {
		roleDao.delete(model);
	}
}