package com.statusraja.admin.dao;

import java.util.List;

public interface GenericDao<T> {

	public T findOne(final long id);

	public List<T> findAll();

	public Integer save(final T entity);

	public void saveOrUpdate(T entity);

	public void update(final T entity);

	public void delete(final T entity);

	public void deleteById(final long entityId);
}
