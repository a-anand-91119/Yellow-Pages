package com.anand.yellowpages.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.anand.yellowpages.domain.User;
import com.anand.yellowpages.rowmappers.UserRowMapper;
import com.anand.yellowpages.utilities.Constants;
import com.anand.yellowpages.utilities.StringUtils;

/**
 * 
 * @author A Anand
 *
 */
@Repository
public class UserDAOImpl extends BaseDAO implements DAO {

	@Override
	public void save(Object object) {
		User user = (User) object;

		String saveQuery = "INSERT INTO USERS "
				+ "(U_NAME, U_PHONENUMBER, U_EMAILADDRESS, U_ADDRESS, U_LOGINNAME, U_PASSWORD, U_ROLE, U_LOGINSTATUS)"
				+ "VALUES (:U_NAME, :U_PHONENUMBER, :U_EMAILADDRESS, :U_ADDRESS, :U_LOGINNAME, :U_PASSWORD, :U_ROLE, :U_LOGINSTATUS)";

		Map<String, Object> bindMap = new HashMap<>();
		bindMap.put("U_NAME", user.getUserName());
		bindMap.put("U_PHONENUMBER", user.getUserPhoneNumber());
		bindMap.put("U_EMAILADDRESS", user.getUserEmailAddress());
		bindMap.put("U_ADDRESS", user.getUserAddress());
		bindMap.put("U_LOGINNAME", user.getUserLoginName());
		bindMap.put("U_PASSWORD", user.getUserPassword());
		bindMap.put("U_ROLE", user.getUserRole());
		bindMap.put("U_LOGINSTATUS", user.getUserLoginStatus());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(bindMap);
		super.getNamedParameterJdbcTemplate().update(saveQuery, sqlParameterSource, keyHolder);
		user.setUserId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(Object object) {
		User user = (User) object;

		String updateQuery = "UPDATE USERS SET " + "U_NAME=:U_NAME, " + "U_PHONENUMBER=:U_PHONENUMBER, "
				+ "U_EMAILADDRESS=:U_EMAILADDRESS, " + "U_ADDRESS=:U_ADDRESS, " + "U_ROLE=:U_ROLE, "
				+ "U_LOGINSTATUS=:U_LOGINSTATUS " + "WHERE U_USERID=:U_USERID";

		Map<String, Object> bindMap = new HashMap<>();
		bindMap.put("U_NAME", user.getUserName());
		bindMap.put("U_PHONENUMBER", user.getUserPhoneNumber());
		bindMap.put("U_EMAILADDRESS", user.getUserEmailAddress());
		bindMap.put("U_ADDRESS", user.getUserAddress());
		bindMap.put("U_ROLE", user.getUserRole());
		bindMap.put("U_LOGINSTATUS", user.getUserLoginStatus());
		bindMap.put("U_USERID", user.getUserId());

		super.getNamedParameterJdbcTemplate().update(updateQuery, bindMap);
	}

	@Override
	public void delete(Object object) {
		this.deleteById(((User) object).getUserId());
	}

	@Override
	public void deleteById(Object object) {
		String deleteQuery = "DELETE FROM USERS WHERE U_USERID = ?";
		getJdbcTemplate().update(deleteQuery, (Long) object);
	}

	@Override
	public Object findById(Object object) {
		String selectQuery = "SELECT U_USERID, U_NAME, U_PHONENUMBER, U_EMAILADDRESS, U_ADDRESS, U_LOGINNAME, U_ROLE, U_LOGINSTATUS"
				+ " FROM USERS WHERE U_USERID = ?";
		return getJdbcTemplate().queryForObject(selectQuery, new UserRowMapper(), object);
	}

	@Override
	public List<?> findAll() {
		String selectQuery = "SELECT U_USERID, U_NAME, U_PHONENUMBER, U_EMAILADDRESS, U_ADDRESS, U_LOGINNAME, U_ROLE, U_LOGINSTATUS"
				+ " FROM USERS";
		return getJdbcTemplate().query(selectQuery, new UserRowMapper());
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {
		String selectQuery = "SELECT U_USERID, U_NAME, U_PHONENUMBER, U_EMAILADDRESS, U_ADDRESS, U_LOGINNAME, U_ROLE, U_LOGINSTATUS"
				+ " FROM USERS WHERE " + propertyName + " = ?";
		return getJdbcTemplate().query(selectQuery, new UserRowMapper(), propertyValue);
	}

	@Override
	public void deleteMultiple(Object[] ids) {
		String deleteQuery = "DELETE FROM USERS WHERE U_USERID IN (?)";
		String concatenatedIds = StringUtils.toConcatenatedString(ids, Constants.COMMA);
		
		getJdbcTemplate().update(deleteQuery, concatenatedIds);
	}

}
