package nl.javoracle.service;

import javax.ejb.Stateless;

@Stateless
public class CurrencyService extends AbstractCrudRepository<CurrencyService>{

	@Override
	protected Class<CurrencyService> getEntityClass() {
		return CurrencyService.class;
	}

}
