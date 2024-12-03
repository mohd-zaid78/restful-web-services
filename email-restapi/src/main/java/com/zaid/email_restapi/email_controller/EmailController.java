package com.zaid.email_restapi.email_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaid.email_restapi.email_request.Email;
import com.zaid.email_restapi.email_request.EmailUser;
import com.zaid.email_restapi.email_response.EmailResponse;
import com.zaid.email_restapi.email_response.UserEmailResponse;
import com.zaid.email_restapi.email_service.EmailServiceInterface;
import com.zaid.email_restapi.exceptionhandler.MailNotDeletedException;
import com.zaid.email_restapi.exceptionhandler.UserNotFoundException;

@RestController
public class EmailController {

	@Autowired
	EmailServiceInterface emailServiceInterface;
	@Autowired
	EmailResponse emailResponse;

	@Autowired
	UserEmailResponse userEmailResponse;

	@PostMapping("/")
	public ResponseEntity<UserEmailResponse> register(@RequestBody EmailUser emailUser) {
		EmailUser emailUserCreated = emailServiceInterface.createEmailUser(emailUser);
		if (emailUserCreated != null && emailUser.equals(emailUserCreated)) {
			userEmailResponse.setError(false);
			userEmailResponse.setMessage("email user is successfully registerd");
			userEmailResponse.setEmailUser(emailUserCreated);
			return ResponseEntity.ok(userEmailResponse);
		} else {
			userEmailResponse.setError(true);
			userEmailResponse.setMessage("email user is not registerd");
			return new ResponseEntity<UserEmailResponse>(userEmailResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<UserEmailResponse> login(@RequestBody EmailUser emailUser) {
		EmailUser loggedIn = emailServiceInterface.read(emailUser);
		if (loggedIn != null && emailUser.getUserName().equals(loggedIn.getUserName())) {
			userEmailResponse.setError(false);
			userEmailResponse.setMessage("email user is successfully login");
			userEmailResponse.setEmailUser(loggedIn);
			return ResponseEntity.ok(userEmailResponse);
		} else {
			
			throw new UserNotFoundException(emailUser.getUserName()+" named user not found");
//			userEmailResponse.setError(true);
//			userEmailResponse.setMessage("email user is not loggedIn");
//			userEmailResponse.setEmailUser(loggedIn);
//			return new ResponseEntity<UserEmailResponse>(userEmailResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/send-email")
	public ResponseEntity<UserEmailResponse> send(@RequestBody Email email) {
		EmailUser sent = emailServiceInterface.send(email);
		if (sent != null && sent.getUserName().equals(email.getFrom())) {
			userEmailResponse.setError(false);
			userEmailResponse.setMessage("email is successfully sent");
			userEmailResponse.setEmailUser(sent);
			return ResponseEntity.ok(userEmailResponse);
		} else {
			userEmailResponse.setError(true);
			userEmailResponse.setMessage("email  is not sent");
			return new ResponseEntity<UserEmailResponse>(userEmailResponse, HttpStatus.OK);
		}
	}
	
	

	@PostMapping("/sent")
	public ResponseEntity<EmailResponse> sent(@RequestBody EmailUser emailUser) {
		List<Email> sentEmailFound = emailServiceInterface.sent(emailUser);
		if (sentEmailFound != null) {

			if (sentEmailFound.isEmpty()) {
				emailResponse.setError(false);
				emailResponse.setMessage("sent emails is successfully fetched but sent box is empty");
				emailResponse.setEmail(sentEmailFound);
				return ResponseEntity.ok(emailResponse);
			} else {
				emailResponse.setError(false);
				emailResponse.setMessage("sent emails is successfully fetched and emails also present inside this ");
				emailResponse.setEmail(sentEmailFound);
				return ResponseEntity.ok(emailResponse);
			}
		} else {
			emailResponse.setError(true);
			emailResponse.setMessage("sent emails is not fetched");
			emailResponse.setEmail(sentEmailFound);
			return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.OK);
		}

	}

	@PostMapping("/inbox")
	public ResponseEntity<EmailResponse> inbox(@RequestBody EmailUser emailUser) {
		List<Email> inboxEmailFound = emailServiceInterface.inbox(emailUser);
		if (inboxEmailFound != null) {
			if (inboxEmailFound.isEmpty()) {
				emailResponse.setError(false);
				emailResponse.setMessage("inbox emails is successfully fetched but the inbox is empty");
				emailResponse.setEmail(inboxEmailFound);
				return ResponseEntity.ok(emailResponse);
			} else {
				emailResponse.setError(false);
				emailResponse.setMessage("inbox emails is successfully fetched and the inbox emails are");
				emailResponse.setEmail(inboxEmailFound);
				return ResponseEntity.ok(emailResponse);
			}

		} else {
			emailResponse.setError(true);
			emailResponse.setMessage("inbox emails  is not fetched");
			emailResponse.setEmail(inboxEmailFound);
			return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.OK);
		}

	}

	@DeleteMapping("/deleteinboxemail/{id}")
	public ResponseEntity<EmailResponse> deleteInboxEmail(@PathVariable int id) {

		Email deletedInboxEmail = emailServiceInterface.deleteInboxEmail(id);
		deletedInboxEmail.getDeleteInboxMail();
		if (deletedInboxEmail != null && deletedInboxEmail.geteId() == id) {
			ArrayList deletedInboxParticularEmail1 = new ArrayList<Email>();
			deletedInboxParticularEmail1.add(deletedInboxEmail);
			emailResponse.setError(false);
			emailResponse.setMessage("inbox email is successfully deleted");
			emailResponse.setEmail(deletedInboxParticularEmail1);
			return ResponseEntity.ok(emailResponse);
		} else {
			
			throw new MailNotDeletedException(id+" id email is not delete");
//			ArrayList deletedInboxParticularEmail1 = new ArrayList<Email>();
//			deletedInboxParticularEmail1.add(deletedInboxEmail);
//			emailResponse.setError(true);
//			emailResponse.setMessage("inbox emails  is not deleted");
//			emailResponse.setEmail(deletedInboxParticularEmail1);
//			return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.OK);
		}

	}

	@DeleteMapping("/deletesentemail/{id}")
	public ResponseEntity<EmailResponse> deleteSentEmail(@PathVariable int id) {

		Email deletedSentEmail = emailServiceInterface.deleteSentEmail(id);
		if (deletedSentEmail != null && deletedSentEmail.geteId() == id) {
			ArrayList deletedSentParticularEmail1 = new ArrayList<Email>();
			deletedSentParticularEmail1.add(deletedSentEmail);
			emailResponse.setError(false);
			emailResponse.setMessage("sent email is successfully deleted");
			emailResponse.setEmail(deletedSentParticularEmail1);
			return ResponseEntity.ok(emailResponse);
		} else {
			ArrayList deletedSentParticularEmail1 = new ArrayList<Email>();
			deletedSentParticularEmail1.add(deletedSentParticularEmail1);
			emailResponse.setError(true);
			emailResponse.setMessage("sent emails  is not deleted");
			emailResponse.setEmail(deletedSentParticularEmail1);
			return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.OK);
		}

	}

	@PostMapping("/drafts")
	public ResponseEntity<EmailResponse> drafts(@RequestBody EmailUser emailUser) {
		List<Email> draftsEmailFound = emailServiceInterface.drafts(emailUser);
		if (draftsEmailFound != null) {

			if (draftsEmailFound.isEmpty()) {
				emailResponse.setError(false);
				emailResponse.setMessage("draft emails is successfully fetched but the drafts is empty");
				emailResponse.setEmail(draftsEmailFound);
				return ResponseEntity.ok(emailResponse);
			} else {
				emailResponse.setError(false);
				emailResponse.setMessage("draft emails is successfully fetched here is the drafts emails are:");
				emailResponse.setEmail(draftsEmailFound);
				return ResponseEntity.ok(emailResponse);
			}

		} else {
			emailResponse.setError(true);
			emailResponse.setMessage("draft emails  is not fetched");
			emailResponse.setEmail(draftsEmailFound);
			return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.OK);

		}

	}
	
}
