package nl.javoracle.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nl.javoracle.model.Product;
import nl.javoracle.service.ProductService;

@Named
@SessionScoped // Een betere oplossing voor dit, niet alles moet in de sessionsscoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = -4246337937697608045L;

	@Inject
	ProductService productService;

	@Inject
	Logger logger;

	public List<Product> list() {
		return productService.findAll();
	}
	
	public void saveProduct(Product product) {
		productService.persist(product);
	}
	
	public Boolean saveProducts(List<Product> products) {
		boolean saveSucceed = false;
		
		if(!products.isEmpty()) {
			for(Product p : products) {
				productService.persist(p);
			}
			saveSucceed = true; // Een betere oplossing voor dit, checken wanneer persist klaar is of ergens fout is
		}
		
		return saveSucceed;
	}
}