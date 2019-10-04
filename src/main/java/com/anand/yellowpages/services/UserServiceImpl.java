package com.anand.yellowpages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anand.yellowpages.dao.BaseDAO;
import com.anand.yellowpages.dao.DAO;
import com.anand.yellowpages.domain.User;
import com.anand.yellowpages.exception.UserBlockedException;

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
		// TODO Auto-generated method stub
		return null;
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
