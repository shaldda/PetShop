package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.Person;

@Stateless
public class PersonService extends AbstractCrudRepository<Person>{

	@Override
	protected Class<Person> getEntityClass() {
		return Person.class;
	}

}
