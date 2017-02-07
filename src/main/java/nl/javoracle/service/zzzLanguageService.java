package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.zzzLanguage;

@Stateless
public class zzzLanguageService extends AbstractCrudRepository<zzzLanguage> {

	@Override
	protected Class<zzzLanguage> getEntityClass() {
		return zzzLanguage.class;
	}


	
}
