package nl.edegier.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The JPA entity class that models the domain object Person. The primary key
 * (id) is generated.
 * 
 * @author Erwin de Gier
 * 
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

}
