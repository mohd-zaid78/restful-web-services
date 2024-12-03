package com.zaid.basepackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaid.basepackage.dao.UserDao;
import com.zaid.basepackage.request.UserRequest;
@Service
public class UserServcieImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public  UserRequest createUser(UserRequest request) {
		return userDao.createUser(request);
		
		
	}
	@Override
	public UserRequest getUser(Integer id) {
		return userDao.getUser(id);
	}

}
