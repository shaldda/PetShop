package nl.javoracle.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import nl.javoracle.common.Parameters;
import nl.javoracle.model.Person;
import nl.javoracle.service.PersonService;

@ManagedBean
public class PersonBean implements Serializable {

	private static final long serialVersionUID = -4246337937697608045L;

	@Inject
	PersonService personService;

	@Inject
	Logger logger;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> list() {
		return personService.findAll();
	}

	public String save() {
		logger.log(Level.INFO, "HOOOOI");
		if (name != null) {
			Person person = new Person();
			person.setName(this.name);
			personService.persist(person);
			logger.log(Level.INFO, "Person " + person.getName() + " saved.");
		}

		return "index";
	}

	public String getTestParameter() {
		return Parameters.TEST.getValue();
	}
}