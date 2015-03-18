package nl.edegier.demo.common;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author Erwin de Gier
 */
public class LoggerConfigurator {

	@Produces
	public Logger get(InjectionPoint ip) {
		Class<?> requestingClass = ip.getMember().getDeclaringClass();
		return Logger.getLogger(requestingClass.getName());
	}

}
