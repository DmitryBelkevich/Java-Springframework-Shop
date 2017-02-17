package com.hard.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.hard.dao.accessors.DatabaseDatasourceAccessor;
import com.hard.models.Model;

public abstract class AbstractDatabaseDaoImpl<T extends Model> extends DatabaseDatasourceAccessor {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public AbstractDatabaseDaoImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<T> getAll() {
		/*Criteria criteria = getSession().createCriteria(clazz);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();*/
		
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		
		Root<T> root = criteriaQuery.from(clazz);
		
		criteriaQuery.select(root).distinct(true);
		
		Query<T> query = getCurrentSession().createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
	public T getById(long id) {
		/*Criteria criteria = getCurrentSession().createCriteria(clazz);
		criteria.add(Restrictions.eq("id", id));
		return (T) criteria.uniqueResult();*/
		
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
		
		Root<T> root = criteriaQuery.from(clazz);
		
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
		
		Query<T> query = getCurrentSession().createQuery(criteriaQuery);
		
		return query.getSingleResult();
	}
	
	public void add(T model) {
		getCurrentSession().save(model);
	}
	
	public void update(T model) {
		getCurrentSession().update(model);
	}
	
	public void delete(T model) {
		getCurrentSession().delete(model);
	}
}