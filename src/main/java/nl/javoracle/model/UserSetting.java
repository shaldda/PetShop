package nl.javoracle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserSetting {
	
	@Id
	@Column(name = "usersetting_id")
	private Long userSettingId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currency currencies;

	@ManyToOne
	@JoinColumn(name = "languages_id")
	private Language languages;
	
	public Long getUserSettingId() {
		return userSettingId;
	}

	public void setUserSettingId(Long userSettingId) {
		this.userSettingId = userSettingId;
	}

	public Currency getCurrencies() {
		return currencies;
	}

	public void setCurrency(Currency currencies) {
		this.currencies = currencies;
	}

	public Language getLanguages() {
		return languages;
	}

	public void setLanguages(Language languages) {
		this.languages = languages;
	}

	public void setCurrencies(Currency currencies) {
		this.currencies = currencies;
	}

	@Column(name = "mail_validation")
	private Boolean mailValidation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getMailValidation() {
		return mailValidation;
	}

	public void setMailValidation(Boolean mailValidation) {
		this.mailValidation = mailValidation;
	}
	
}
