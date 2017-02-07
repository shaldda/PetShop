package nl.javoracle.service;

import javax.ejb.Stateless;

import nl.javoracle.model.zzzUserSetting;

@Stateless
public class zzzUserSettingService extends AbstractCrudRepository<zzzUserSetting>{

	@Override
	protected Class<zzzUserSetting> getEntityClass() {
		return zzzUserSetting.class;
	}

}
