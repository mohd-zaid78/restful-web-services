package com.zaid.email_restapi.email_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaid.email_restapi.email_request.Email;
import com.zaid.email_restapi.email_request.EmailUser;

public interface EmailRepository extends JpaRepository<Email, Integer> {

	
	List<Email> findByFromAndDeleteSentMailAndEmailDrafts(String foundedUserName, int i, int j);

	List<Email> findByFromAndDeleteInboxMailAndEmailDrafts(String foundedUserName, int i, int j);

	List<Email> findByFromAndEmailDrafts(String foundedUserName, int i);

}
