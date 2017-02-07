package nl.javoracle.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nl.javoracle.model.Account;
import nl.javoracle.service.AccountService;

@Named
@SessionScoped
public class AccountBean implements Serializable{

	private static final long serialVersionUID = 7485862480051145278L;
	
	@Inject
	Logger logger;
	
	@Inject
	AccountService accountService;
	
	private Account account;
	
	@PostConstruct
	private void initializeBean() {
		account = new Account();
	 }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void saveAccount(Account account) {
		accountService.persist(account);
	}

}
