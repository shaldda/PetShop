package nl.javoracle.common;


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
