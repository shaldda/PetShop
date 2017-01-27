package nl.javoracle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import nl.javoracle.model.Person;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	private long userId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	Person person;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	UserSetting userSetting;
	
	public UserSetting getUserSetting() {
		return userSetting;
	}

	public void setUserSetting(UserSetting userSetting) {
		this.userSetting = userSetting;
	}

	@Column(name = "username")
	String userName;
	@Column(name = "role")
	int role;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
	
	
	

}
