package com.zaid.email_restapi.email_request;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IncrementGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Email {
	
	@Id
	@GeneratedValue(generator = "zaid")
	@GenericGenerator(name="zaid",strategy = "increment")
	private Integer eId ;
	private String subject;
	private String body;
	@Column(name="sender")
	private String from;
	@Column(name="reciever")
	private String to;
	@JsonIgnore
	private int deleteInboxMail;
	@JsonIgnore
	private int deleteSentMail;
	@JsonIgnore
	private int emailDrafts;
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getDeleteInboxMail() {
		return deleteInboxMail;
	}
	public void setDeleteInboxMail(int deleteInboxMail) {
		this.deleteInboxMail = deleteInboxMail;
	}
	public int getDeleteSentMail() {
		return deleteSentMail;
	}
	public void setDeleteSentMail(int deleteSentMail) {
		this.deleteSentMail = deleteSentMail;
	}
	public int getEmailDrafts() {
		return emailDrafts;
	}
	public void setEmailDrafts(int emailDrafts) {
		this.emailDrafts = emailDrafts;
	}
	@Override
	public int hashCode() {
		return Objects.hash(body, deleteInboxMail, deleteSentMail, eId, emailDrafts, from, subject, to);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(body, other.body) && deleteInboxMail == other.deleteInboxMail
				&& deleteSentMail == other.deleteSentMail && Objects.equals(eId, other.eId)
				&& emailDrafts == other.emailDrafts && Objects.equals(from, other.from)
				&& Objects.equals(subject, other.subject) && Objects.equals(to, other.to);
	}
	@Override
	public String toString() {
		return "Email [eId=" + eId + ", subject=" + subject + ", body=" + body + ", from=" + from + ", to=" + to
				+ ", deleteInboxMail=" + deleteInboxMail + ", deleteSentMail=" + deleteSentMail + ", emailDrafts="
				+ emailDrafts + "]";
	}
	
	
	
	
	
	

}
