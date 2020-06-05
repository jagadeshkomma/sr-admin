package com.statusraja.admin.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class GenericDaoImpl<T> implements GenericDao<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> clazz;

	public T findOne(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public Integer save(T entity) {
		return (Integer)getCurrentSession().save(entity);
	}
	
	@Override
    public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
    }

	public void update(T entity) {
		getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
