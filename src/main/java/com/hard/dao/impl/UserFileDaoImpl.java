package com.hard.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hard.dao.UserDao;
import com.hard.models.User;

@Repository("userFileDao")
public class UserFileDaoImpl extends AbstractFileDaoImpl<User> implements UserDao {
	public UserFileDaoImpl() {
		
	}
	
	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}