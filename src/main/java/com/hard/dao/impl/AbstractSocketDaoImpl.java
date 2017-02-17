package com.hard.dao.impl;

import java.util.List;

import com.hard.dao.accessors.SocketDatasourceAccessor;
import com.hard.models.Model;

public abstract class AbstractSocketDaoImpl<T extends Model> extends SocketDatasourceAccessor {
	private String host;
	private String port;
	
	public List<T> getAll() {
		// TODO method stub
		return null;
	}
	
	public T getById(long id) {
		// TODO method stub
		return null;
	}
	
	public void add(T model) {
		// TODO method stub
	}
	
	public void update(T model) {
		// TODO method stub
	}
	
	public void delete(T model) {
		// TODO method stub
	}
	
	/*public Avatar getByPage(int page) {
		return null;
	}*/
	
	@Override
	public String getHost() {
		return host;
	}
	
	@Override
	public int getPort() {
		return Integer.parseInt(port);
	}
}