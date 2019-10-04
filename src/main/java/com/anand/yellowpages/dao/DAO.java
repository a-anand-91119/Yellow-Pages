package com.anand.yellowpages.dao;

import java.util.List;

/**
 * 
 * @author A Anand
 *
 */
public interface DAO {

	public void save(Object object);

	public void update(Object object);

	public void delete(Object object);

	public void deleteById(Object id);

	public Object findById(Object id);

	public List<?> findAll();

	public List<?> findByProperty(String propertyName, Object propertyValue);
	
	public void deleteMultiple(Object[] ids);
}
