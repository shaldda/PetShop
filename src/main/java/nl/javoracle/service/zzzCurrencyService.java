package nl.javoracle.service;

import javax.ejb.Stateless;

@Stateless
public class zzzCurrencyService extends AbstractCrudRepository<zzzCurrencyService>{

	@Override
	protected Class<zzzCurrencyService> getEntityClass() {
		return zzzCurrencyService.class;
	}

}
