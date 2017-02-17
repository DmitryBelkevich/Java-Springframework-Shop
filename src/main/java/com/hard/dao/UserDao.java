package com.hard.dao;

import com.hard.models.User;

public interface UserDao extends ModelDao<User> {
	public User getByUsername(String username);
}