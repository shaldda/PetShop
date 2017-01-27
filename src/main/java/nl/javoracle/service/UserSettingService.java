package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.UserSetting;

@Stateless
public class UserSettingService extends AbstractCrudRepository<UserSetting>{

	@Override
	protected Class<UserSetting> getEntityClass() {
		return UserSetting.class;
	}

}
