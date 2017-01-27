package nl.javoracle.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
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
	private HashMap<Product, Integer> hashCart;
	private double totalPrice;

	@Inject
	Logger logger;
	
	@PostConstruct
	private void initializeBean() {
		shoppingCart = new ArrayList<Product>();
		hashCart = new HashMap<Product, Integer>();
	 }

	public void addToCart(Product x) {
		shoppingCart.add(x);
	}
	
	public ArrayList<Product> getCart() {
		return shoppingCart;
//		ArrayList<Product> groupedCart = new ArrayList<Product>();
//		logger.log(Level.INFO, String.valueOf("size" + shoppingCart.size()));
//		contains:
//		for(Product p : shoppingCart) {
//			logger.log(Level.INFO, String.valueOf("id" + p.getProductId()));
//			if(!groupedCart.isEmpty()) {
//				boolean available = false;
//				for(Product gp: groupedCart) {
//					logger.log(Level.INFO, String.valueOf("in"));
//					if(p.getProductId() == gp.getProductId()) {
//						logger.log(Level.INFO, String.valueOf("found" + p.getProductId()));
//						continue contains;
//					} else {
//						logger.log(Level.INFO, String.valueOf("not") + p.getProductId());
//						//groupedCart.add(p); contains error
//					}		
//				}	
//			} else {
//				groupedCart.add(p);
//			} 
//		}
//		return groupedCart;
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
	
	public int getAmountEachProduct(Product product) {
		int sum = 0;
		for( Product p : shoppingCart) {
			if(p.getProductId() == product.getProductId()) {
				sum++;
			}
		}
		logger.log(Level.INFO, String.valueOf(sum));
		return sum;
	}
	
	/* All HashMethods */
	
	public void addToHashCart(Product product) {
		logger.log(Level.INFO, String.valueOf("product" + product));
		Integer key = hashCart.get(product);
		logger.log(Level.INFO, String.valueOf("what is this" + key));
		if( key == null) {
			logger.log(Level.INFO, String.valueOf("hiertoch" + key));
			hashCart.put(product, 0);
			logger.log(Level.INFO, String.valueOf("prodyct" + hashCart.get(product)));
		} else {
			logger.log(Level.INFO, String.valueOf("hmmm" + key));
			//hashCart.put(product, hashCart.get(product)+1);
		}
		
	}
	
	public void removeFromHashCart(Product product) {
		if(hashCart.get(product) != null) {
			
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
//		HttpSession session = request.getSession();
//		shoppingCart = (Cart) session.getAttribute("cart");
		
//		
//		Session session = entityManager.unwrap(Session.class);
//		SessionFactory sessionFactory = session.getSessionFactory();
//		Product p = sessionFactory.getCurrentSession().;
//		for(String c : sessionFactory.getAllClassMetadata().keySet()) {
//			logger.log(Level.INFO, String.valueOf(sessionFactory.getAllClassMetadata().get(c)));
//		}
		
