package com.zaid.email_restapi.email_dao;

import java.util.List;

import com.zaid.email_restapi.email_request.Email;
import com.zaid.email_restapi.email_request.EmailUser;

public interface EmailDaoInterface {

	EmailUser createEmailUser(EmailUser emailUser);

	EmailUser read(EmailUser emailUser);

	EmailUser send(Email email);

	List<Email> sent(EmailUser emailUser);

	List<Email> inbox(EmailUser emailUser);

	Email deleteInboxEmail(int id);

	Email deleteSentEmail(int id);

	List<Email> drafts(EmailUser emailUser);

}
