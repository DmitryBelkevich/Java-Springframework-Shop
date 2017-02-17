package com.hard.dao.impl;

import org.springframework.stereotype.Repository;

import com.hard.dao.RoleDao;
import com.hard.models.Role;

@Repository("roleDatabaseDao")
public class RoleDatabaseDaoImpl extends AbstractDatabaseDaoImpl<Role> implements RoleDao {
	public RoleDatabaseDaoImpl() {
		
	}
}