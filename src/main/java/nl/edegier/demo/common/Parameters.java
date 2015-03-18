package nl.edegier.demo.common;



/**
 * This enumeration takes care of the dynamic lookup (no restart required) of
 * properties Properties are defined as KEY(defaultvalue) enumerations. Upon
 * retrieval the property resource is loaded, if a property with KEY exists, the
 * corresponding value is returned, else the defaultvalue is returned
 * 
 * @author Erwin de Gier
 * 
 */
public enum Parameters {
	TEST("default");

	private String defaultValue;

	private Parameters(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the value for this enum if exists, otherwise the default
	 */
	public String getValue() {
		String sysPropValue = System.getProperty(this.toString());
		return sysPropValue != null ? sysPropValue : this.defaultValue;
	}

	public int getIntValue() {
		return Integer.valueOf(this.getValue());
	}
}
