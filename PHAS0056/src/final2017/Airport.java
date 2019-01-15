package final2017;

import java.util.Scanner;

public class Airport {

	private String code;
	private String name;
	private String timeZone;

	/**
	 * empty constructor for airport object
	 */
	public Airport() {

	}
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

	public static Airport ParseLine(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(",");
		Airport a = new Airport();

		if (s.hasNext()) {
			a.code = s.next();
			a.name = s.next();
			a.timeZone = s.next();

		}
		s.close();
		return a;
	}
}
