package com.zaid.basepackage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaid.basepackage.repo.UserRepo;
import com.zaid.basepackage.request.UserRequest;
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserRequest createUser(UserRequest request) {
		return  userRepo.save(request);
		
	}
	@Override
	public UserRequest getUser(Integer id) {
		return userRepo.findById(id).orElse(null);
	}

}
