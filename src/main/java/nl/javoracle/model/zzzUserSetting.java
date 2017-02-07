package nl.javoracle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class zzzUserSetting {
	
	@Id
	@Column(name = "usersetting_id")
	private Long userSettingId;
	
	@ManyToOne
	@JoinColumn(name = "currency_id")
	private zzzCurrency currencies;

	@ManyToOne
	@JoinColumn(name = "languages_id")
	private zzzLanguage languages;
	
	// Not used Yet //
	private Account user;
	
	public Long getUserSettingId() {
		return userSettingId;
	}

	public void setUserSettingId(Long userSettingId) {
		this.userSettingId = userSettingId;
	}

	public zzzCurrency getCurrencies() {
		return currencies;
	}

	public void setCurrency(zzzCurrency currencies) {
		this.currencies = currencies;
	}

	public zzzLanguage getLanguages() {
		return languages;
	}

	public void setLanguages(zzzLanguage languages) {
		this.languages = languages;
	}

	public void setCurrencies(zzzCurrency currencies) {
		this.currencies = currencies;
	}

	@Column(name = "mail_validation")
	private Boolean mailValidation;

	public Boolean getMailValidation() {
		return mailValidation;
	}

	public void setMailValidation(Boolean mailValidation) {
		this.mailValidation = mailValidation;
	}
	
}
