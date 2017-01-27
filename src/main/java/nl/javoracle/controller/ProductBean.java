package nl.javoracle.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
	
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import nl.javoracle.common.Parameters;
import nl.javoracle.model.Product;
import nl.javoracle.service.ProductService;

@ManagedBean
public class ProductBean implements Serializable {

	private static final long serialVersionUID = -4246337937697608045L;

	@Inject
	ProductService productService;

	@Inject
	Logger logger;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addToCart() {
		
	}

	public List<Product> list() {
		return productService.findAll();
	}

	public String save() {
		logger.log(Level.INFO, "HOOOOI");
		if (name != null) {
			Product product = new Product();
			product.setName(this.name);
			productService.persist(product);
			logger.log(Level.INFO, "Person " + product.getName() + " saved.");
		}

		return "hello";
	}

	public String getTestParameter() {
		return Parameters.TEST.getValue();
	}
}