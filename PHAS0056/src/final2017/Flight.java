package final2017;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Flight {

	private String flightcode;
	private String origin;
	private String destination;
	private String departureDate;
	private String departureTime;
	private String arrivalDate;
	private String arrivalTime;
	private double cost;

	/**
	 * @return the flightCOde
	 */
	public String getFlightcode() {
		return flightcode;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
	}

	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [flightcode=" + flightcode + ", origin=" + origin + ", destination=" + destination
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", arrivalDate="
				+ arrivalDate + ", arrivalTime=" + arrivalTime + ", cost=" + cost + ", duration=" + this.flightTime()
				+ "]";
	}


	/**
	 * Empty constructor
	 */
	public Flight() {

	}

	/**
	 * Constructor for Flight object
	 */
	public Flight(String flightCode, String origin, String destination, String departureDate, String departureTime,
			String arrivalDate, String arrivalTime, double cost) {
		this.flightcode = flightCode;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Parses line of data into parameters and returns Flight object
	 */
	public static Flight parseLine(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(", ");
		Flight f = new Flight();
		if (s.hasNext()) {
			f.flightcode = s.next();
			f.origin = s.next();
			f.destination = s.next();
			f.departureDate = s.next();
			f.departureTime = s.next();
			f.arrivalDate = s.next();
			f.arrivalTime = s.next();
			f.cost = s.nextDouble();
		}
		s.close();
		return f;
	}

	/**
	 * Method for finding flight time between time zones
	 * 
	 * @return Duration in minutes
	 */
	public long flightTime() {
		LocalDateTime lt1 = LocalDateTime.parse(this.departureDate + "T" + this.departureTime);
		ZoneId z1 = ZoneId.of("Europe/London");
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);

		LocalDateTime lt2 = LocalDateTime.parse(this.arrivalDate + "T" + this.arrivalTime);
		ZoneId z2 = ZoneId.of("Europe/Paris");
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);

		long duration = zt1.until(zt2, ChronoUnit.MINUTES);
		return duration;
	}

}
