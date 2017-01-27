package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.Language;

@Stateless
public class LanguageService extends AbstractCrudRepository<Language> {

	@Override
	protected Class<Language> getEntityClass() {
		return Language.class;
	}


	
}
