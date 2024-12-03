package com.zaid.basepackage.dao;

import com.zaid.basepackage.request.UserRequest;

public interface UserDao {

	public UserRequest createUser(UserRequest request);

	public UserRequest getUser(Integer id);
	

}
