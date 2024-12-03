package com.zaid.email_restapi.email_request;

import java.util.List;
import java.util.Objects;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class EmailUser {

	@Id
	@GeneratedValue(generator = "zaid")
	@GenericGenerator(name = "zaid", strategy = "increment")
	private Integer uId;
	private String userName;
	private String password;
	private String emailId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "uId")
	private List<Email> emailList;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Email> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, emailList, password, uId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailUser other = (EmailUser) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(emailList, other.emailList)
				&& Objects.equals(password, other.password) && Objects.equals(uId, other.uId)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "EmailUser [uId=" + uId + ", userName=" + userName + ", password=" + password + ", emailId=" + emailId
				+ ", emailList=" + emailList + "]";
	}

	
}
