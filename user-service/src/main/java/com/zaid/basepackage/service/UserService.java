package com.zaid.basepackage.service;

import com.zaid.basepackage.request.UserRequest;

public interface UserService {

	public UserRequest createUser( UserRequest request);

	public UserRequest getUser(Integer id);
	
	

}
