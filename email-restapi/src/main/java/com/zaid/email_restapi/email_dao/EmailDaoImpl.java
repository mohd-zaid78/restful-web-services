package com.zaid.email_restapi.email_dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.zaid.email_restapi.email_repository.EmailRepository;
import com.zaid.email_restapi.email_repository.EmailUserRepository;
import com.zaid.email_restapi.email_request.Email;
import com.zaid.email_restapi.email_request.EmailUser;

@Component
public class EmailDaoImpl implements EmailDaoInterface {

	@Autowired
	private EmailUserRepository emailUserRepository;

	@Autowired
	private EmailRepository emailRepository;

	@Override
	public EmailUser createEmailUser(EmailUser emailUser) {
		EmailUser emailUserCreated = emailUserRepository.save(emailUser);
		return emailUserCreated;
	}

	@Override
	public EmailUser read(EmailUser emailUser) {
		EmailUser loggedIn = emailUserRepository.findByUserNameAndPassword(emailUser.getUserName(),
				emailUser.getPassword());
		return loggedIn;
	}

	@Override
	public EmailUser send(Email email) {
		String from = email.getFrom();
		EmailUser foundSender = emailUserRepository.findByUserName(from);
		String to = email.getTo();
		EmailUser foundReciever = emailUserRepository.findByUserName(to);
		boolean added = false;
		if (foundReciever != null && to.equals(foundReciever.getUserName())) {
			if (foundSender != null && foundSender.getUserName().equals(from) && foundSender.getEmailList() == null) {
				foundSender.setEmailList(new ArrayList<Email>());
			} else if (foundSender != null && foundSender.getUserName().equals(from)) {
				added = foundSender.getEmailList().add(email);
			}
			if (added) {
				EmailUser sent = emailUserRepository.save(foundSender);
				return sent;
			}

		}
		return null;

	}

	@Override
	public List<Email> sent(EmailUser emailUser) {
		String userName = emailUser.getUserName();
		EmailUser foundUser = emailUserRepository.findByUserName(userName);
		if (foundUser != null && userName.equals(foundUser.getUserName())) {
			String foundedUserName = foundUser.getUserName();
			List<Email> sentEmailFound = emailRepository.findByFromAndDeleteSentMailAndEmailDrafts(foundedUserName, 0,
					0);
			return sentEmailFound;
		}
		return null;

	}

	@Override
	public List<Email> inbox(EmailUser emailUser) {
		String userName = emailUser.getUserName();
		EmailUser foundUser = emailUserRepository.findByUserName(userName);
		if (foundUser != null && userName.equals(foundUser.getUserName())) {
			String foundedUserName = foundUser.getUserName();
			List<Email> inboxEmailFound = emailRepository.findByFromAndDeleteInboxMailAndEmailDrafts(foundedUserName, 0,
					0);
			return inboxEmailFound;
		}
		return null;
	}

	@Override
	public Email deleteInboxEmail(int id) {
		Email emailFound = emailRepository.findById(id).orElse(null);
		if (emailFound != null && emailFound.geteId() == id) {
			emailFound.setDeleteInboxMail(1);
			Email deletedInboxEmail = emailRepository.save(emailFound);
			return deletedInboxEmail;
		}
		return null;
	}

	@Override
	public Email deleteSentEmail(int id) {
		Email emailFound = emailRepository.findById(id).orElse(null);
		if (emailFound != null && emailFound.geteId() == id) {
			emailFound.setDeleteSentMail(1);
			Email deletedSentEmail = emailRepository.save(emailFound);

			return deletedSentEmail;
		}
		return null;
	}

	@Override
	public List<Email> drafts(EmailUser emailUser) {
		String userName = emailUser.getUserName();
		EmailUser foundUser = emailUserRepository.findByUserName(userName);
		if (foundUser != null && userName.equals(foundUser.getUserName())) {
			String foundedUserName = foundUser.getUserName();
			List<Email> draftEmailsFound = emailRepository.findByFromAndEmailDrafts(foundedUserName, 1);
			return draftEmailsFound;
		}
		return null;
	}

}
