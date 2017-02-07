package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.Account;

@Stateless
public class AccountService extends AbstractCrudRepository<Account>{

	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}

}
