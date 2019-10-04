package com.anand.yellowpages.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.anand.yellowpages.domain.User;

/**
 * 
 * @author A Anand
 *
 */
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getLong("U_USERID"));
		user.setUserName(rs.getString("U_NAME"));
		user.setUserAddress(rs.getString("U_ADDRESS"));
		user.setUserEmailAddress(rs.getString("U_EMAILADDRESS"));
		user.setUserLoginName(rs.getString("U_LOGINNAME"));
		user.setUserRole(rs.getString("U_ROLE"));
		user.setUserLoginStatus(rs.getString("U_LOGINSTATUS"));
		return user;
	}

}
