package com.anand.yellowpages.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.anand.yellowpages.dao.BaseDAO;
import com.anand.yellowpages.dao.DAO;
import com.anand.yellowpages.domain.User;
import com.anand.yellowpages.exception.UserBlockedException;
import com.anand.yellowpages.rowmappers.UserRowMapper;
import com.anand.yellowpages.utilities.ServiceConstants;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{

	@Autowired
	@Qualifier(value = "userDAOImpl")
	private DAO userDAOImpl;
	
	@Override
	public void register(User user) {
		userDAOImpl.save(user);
	}

	@Override
	public User login(String loginName, String loginPassword) throws UserBlockedException {
		
		String loginQuery = "SELECT U_USERID, U_NAME, U_PHONENUMBER, U_ADDRESS, U_EMAILADDRESS, U_ROLE, U_LOGINSTATUS, U_LOGINNAME"
				+ " FROM USERS WHERE U_LOGINNAME=:U_LOGINNAME AND U_PASSWORD=:U_PASSWORD";
		
		Map<String, String> bindMap = new HashMap<String, String>();
		bindMap.put("U_LOGINNAME", loginName);
		bindMap.put("U_PASSWORD", loginPassword);
		
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(loginQuery, bindMap, new UserRowMapper());
			
			if(user.getUserLoginStatus().equals(ServiceConstants.LOGIN_STATUS_BLOCKED))
				throw new UserBlockedException("Your Account Has Been Blocked. Please Contact Admin For Help.");
			
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Long userId, Integer loginStatus) {
		// TODO Auto-generated method stub	
	}

}
