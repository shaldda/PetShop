package nl.javoracle.service;

import static org.junit.Assert.assertNotNull;

import nl.javoracle.model.Person;
import nl.javoracle.service.PersonService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonRepositoryTest extends AbstractTest {

	PersonService repository;

	@Before
	public void setup() {
		repository = new PersonService();
		repository.entityManager = getEntityManager();
		getTransaction().begin();
	}

	@Test
	public void testPersist() {
		
		Person person = new Person();
		person.setName("test");
		person = repository.persist(person);
		assertNotNull(repository.find(person.getPersonId()));
	}

	@After
	public void teardown() {
		if (getTransaction().isActive()) {
			getTransaction().rollback();
		}
	}

}
