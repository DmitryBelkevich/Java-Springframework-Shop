package com.hard.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hard.dao.UserDao;
import com.hard.models.User;
import com.hard.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDatabaseDao")
	private UserDao userDao;
	
	public UserServiceImpl() {
		
	}
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	@Override
	public User getById(long id) {
		return userDao.getById(id);
	}
	
	@Override
	public void add(User model) {
		userDao.add(model);
	}
	
	@Override
	public void update(User model) {
		userDao.update(model);
	}
	
	@Override
	public void delete(User model) {
		userDao.delete(model);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("user with name " + username + " not found");
		
		return user;
	}
}