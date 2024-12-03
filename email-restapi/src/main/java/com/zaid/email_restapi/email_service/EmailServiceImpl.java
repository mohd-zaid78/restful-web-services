package com.zaid.email_restapi.email_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaid.email_restapi.email_dao.EmailDaoInterface;
import com.zaid.email_restapi.email_request.Email;
import com.zaid.email_restapi.email_request.EmailUser;

@Service
public class EmailServiceImpl implements EmailServiceInterface {
	
	@Autowired
	EmailDaoInterface emailDaoInterface;
	
	@Override
	public EmailUser createEmailUser(EmailUser emailUser) {
		EmailUser emailUserCreated=emailDaoInterface.createEmailUser(emailUser);
		return emailUserCreated;
	}

	@Override
	public EmailUser read(EmailUser emailUser) {
		EmailUser loggedIn=emailDaoInterface.read(emailUser);
		return loggedIn;
	}

	@Override
	public EmailUser send(Email email) {
		EmailUser sent=emailDaoInterface.send(email);
		return sent;
	}

	@Override
	public List<Email> sent(EmailUser emailUser) {
		List<Email> sentEmailFound=emailDaoInterface.sent(emailUser);
		return sentEmailFound;
	}

	@Override
	public List<Email> inbox(EmailUser emailUser) {
		List<Email> inboxEmailFound=emailDaoInterface.inbox(emailUser);
		return inboxEmailFound;
	}

	@Override
	public Email deleteInboxEmail(int id) {
		Email deletedInboxEmail = emailDaoInterface.deleteInboxEmail(id);
		return deletedInboxEmail;
	}

	@Override
	public Email deleteSentEmail(int id) {
		Email deletedSentEmail = emailDaoInterface.deleteSentEmail(id);
		return deletedSentEmail;
	}

	@Override
	public List<Email> drafts(EmailUser emailUser) {
		List<Email> DraftEmailsFound=emailDaoInterface.drafts(emailUser);
		return DraftEmailsFound;
	}

}
