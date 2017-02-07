package nl.javoracle.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nl.javoracle.model.Person;
import nl.javoracle.service.PersonService;

@Named
@SessionScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = -4246337937697608045L;
	
	private Person person;

	@Inject
	PersonService personService;

	@Inject
	Logger logger;
	
	@PostConstruct
	private void initializeBean() {
		person = new Person();
	 }

	public List<Person> list() {
		return personService.findAll();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void savePerson(Person person) {
		personService.persist(person);
	}
}