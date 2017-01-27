package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.Product;

@Stateless
public class ProductService extends AbstractCrudRepository<Product>{

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

}
