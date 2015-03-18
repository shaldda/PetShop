package nl.edegier.demo.service;

import javax.ejb.Stateless;

import nl.edegier.demo.model.Person;

/**
 * This is a stateless session bean that handles Create, Read, update, delete actions for the Person entity.
 * We use an EJB to leverage Container Managed Transaction
 * 
 * @author Erwin de Gier
 *
 */
@Stateless
public class PersonService extends AbstractCrudRepository<Person>{

	@Override
	protected Class<Person> getEntityClass() {
		return Person.class;
	}

}
