package nl.edegier.demo.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import nl.edegier.demo.common.Parameters;
import nl.edegier.demo.model.Person;
import nl.edegier.demo.service.PersonService;

/**
 * This is the JSF managed bean that handles calls from the home.xhtml This
 * class uses the PersonService EJB, injected by the container by use of the @Inject
 * annotation.
 * 
 * @author Erwin de Gier
 * 
 */
@ManagedBean
public class PersonBean implements Serializable {

	/**
	 * 
	 */
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
		if (name != null) {
			Person person = new Person();
			person.setName(this.name);
			personService.persist(person);
			logger.log(Level.INFO, "Person " + person.getName() + " saved.");
		}

		return "hello";
	}

	public String getTestParameter() {
		return Parameters.TEST.getValue();
	}
}