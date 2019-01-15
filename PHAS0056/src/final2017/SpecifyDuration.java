package final2017;

import java.util.ArrayList;

public class SpecifyDuration implements FlightFilter {

	double limit;

	public SpecifyDuration(double limit) {
		this.limit = limit;
	}

	public ArrayList<Flight> filter(ArrayList<Flight> list) {
		ArrayList<Flight> filtered = new ArrayList<Flight>();

		for (Flight f : list) {
			if (f.flightTime() <= this.limit) {
				filtered.add(f);
			}
		}
		return filtered;
	}

}
