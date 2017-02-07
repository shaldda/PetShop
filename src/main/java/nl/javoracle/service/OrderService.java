package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.Order;

@Stateless
public class OrderService extends AbstractCrudRepository<Order>{

	@Override
	protected Class<Order> getEntityClass() {
		return Order.class;
	}

}
