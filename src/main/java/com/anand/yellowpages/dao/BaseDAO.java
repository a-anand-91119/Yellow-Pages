package com.anand.yellowpages.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * 
 * @author A Anand
 *
 */
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

	@Autowired
	public void setDataSourceInDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
