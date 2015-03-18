package nl.edegier.demo.service;

import static org.junit.Assert.assertNotNull;
import nl.edegier.demo.model.Person;
import nl.edegier.demo.service.PersonService;

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
		assertNotNull(repository.find(person.getId()));
	}

	@After
	public void teardown() {
		if (getTransaction().isActive()) {
			getTransaction().rollback();
		}
	}

}
