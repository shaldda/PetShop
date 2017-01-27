package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.User;

@Stateless
public class UserService extends AbstractCrudRepository<User>{

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
