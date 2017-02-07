package nl.javoracle.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="weborder")
public class Order {
	
	@Id
	@GeneratedValue
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	@NotNull
	private Person person;
	
	@ManyToMany
	@JoinTable(name = "order_product")
	@NotNull
	private List<Product> product;
	

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


}
