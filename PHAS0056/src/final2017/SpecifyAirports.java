package final2017;

import java.util.ArrayList;

public class SpecifyAirports implements FlightFilter {

	String origin;
	String destination;

	public SpecifyAirports(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public ArrayList<Flight> filter(ArrayList<Flight> list) {
		ArrayList<Flight> filtered = new ArrayList<Flight>();

		for (Flight f : list) {
			if (f.getOrigin().equals(this.origin) && f.getDestination().equals(this.destination)) {
				filtered.add(f);
			}
		}
		return filtered;
	}
}
