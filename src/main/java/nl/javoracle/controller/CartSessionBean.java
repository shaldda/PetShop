package nl.javoracle.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.javoracle.model.Product;

@Named
@SessionScoped
public class CartSessionBean implements Serializable {
	//private static final long serialVersionUID = -4246337937697608045L;
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager entityManager;
	private ArrayList<Product> shoppingCart;
	private double totalPrice;

	@Inject
	Logger logger;
	
	@PostConstruct
	private void initializeBean() {
		shoppingCart = new ArrayList<Product>();
	 }

	public void addToCart(Product x) {
		shoppingCart.add(x);
	}
	
	public double getTotalPrice() {
		totalPrice = 0;
		for( Product product : shoppingCart) {
			totalPrice += product.getPrice();
		}
		
		return totalPrice;
	}
	
	public int getShoppingCartSize() {
		return (!shoppingCart.isEmpty() ? shoppingCart.size() : 0);
	}
	
	public String removeFromCart(Product product) {
		shoppingCart.remove(product);
		return "order";
	}
	
	public Map<Product, Integer> getCart() {
		Map<Product, Integer> uniqueSet = new HashMap<Product, Integer>();
		
		for (Product product : shoppingCart) {
			uniqueSet.computeIfAbsent(product, k -> Collections.frequency(shoppingCart, product));
//			if(uniqueSet.get(product) == null) {
//				uniqueSet.put(product, Collections.frequency(shoppingCart, product));
//			}
		}
		
		return uniqueSet;
	}
	
}
