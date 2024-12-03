package com.zaid.email_restapi.email_repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zaid.email_restapi.email_request.EmailUser;

public interface EmailUserRepository extends JpaRepository<EmailUser, Integer> {

	 @EntityGraph(attributePaths = {"emailList"})
	EmailUser findByUserNameAndPassword(String userName, String password);

	EmailUser findByUserName(String to);

	
}
