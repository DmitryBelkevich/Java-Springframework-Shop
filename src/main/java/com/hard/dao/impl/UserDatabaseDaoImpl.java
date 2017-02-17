package com.hard.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.hard.dao.UserDao;
import com.hard.models.User;

@Repository("userDatabaseDao")
public class UserDatabaseDaoImpl extends AbstractDatabaseDaoImpl<User> implements UserDao {
	public UserDatabaseDaoImpl() {
		
	}
	
	@Override
	public User getByUsername(String username) {
		/*Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		
		return (User) criteria.uniqueResult();*/
		
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		
		Root<User> user = criteriaQuery.from(User.class);
		
		criteriaQuery.where(criteriaBuilder.equal(user.get("username"), username));
		
		Query<User> query = getCurrentSession().createQuery(criteriaQuery);
		
		return query.getSingleResult();
	}
}