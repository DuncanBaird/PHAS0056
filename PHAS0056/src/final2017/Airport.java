package final2017;

public class Airport {

	private String code;
	private String name;
	private String timeZone;

	/**
	 * constructor for airport object
	 * 
	 * @param code
	 * @param name
	 * @param timeZone
	 */
	public Airport(String code, String name, String timeZone) {
		this.code = code;
		this.name = name;
		this.timeZone = timeZone;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Airport [code=" + code + ", name=" + name + ", timeZone=" + timeZone + "]";
	}

}
