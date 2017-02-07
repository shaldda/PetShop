package nl.javoracle.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import nl.javoracle.model.Account;
import nl.javoracle.model.Order;
import nl.javoracle.model.Person;
import nl.javoracle.model.Product;
import nl.javoracle.service.OrderService;		

@ManagedBean
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 572077445205450927L;
	
	@Inject
	Logger logger;
	
	private Order order;
	
	@Inject 
	private OrderService orderservice;
	
	@Inject
	private PersonBean personBean;
	
	@Inject
	private AccountBean accountBean;
	
	@Inject 
	private CartSessionBean cartSessionBean;
	
	@PostConstruct
	private void initializeBean() {
		order = new Order();
	 }
	
	public String submitOrder() {
		Person mPerson = personBean.getPerson();
		Account mAccount = accountBean.getAccount();
		List<Product> mProducts = cartSessionBean.getCartList();
		
		mAccount.setPerson(mPerson);
		order.setProduct(mProducts);
		order.setPerson(mPerson);
		personBean.savePerson(mPerson);
		accountBean.saveAccount(mAccount);
		orderservice.persist(order);
		
		resetOrder();
		
		return "index";
		
	}

	private void resetOrder() {
		personBean.setPerson(new Person());
		accountBean.setAccount(new Account());
		order = new Order();
		cartSessionBean.emptyCart();
		
		showConfirmation();
	}
	
	private void showConfirmation() {
		String message = "De bestelling is succesvol afgerond";
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

}
