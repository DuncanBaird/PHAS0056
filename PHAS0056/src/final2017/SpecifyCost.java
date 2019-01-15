package final2017;

import java.util.ArrayList;

public class SpecifyCost implements FlightFilter {

	double limit;

	public SpecifyCost(double limit) {
		this.limit = limit;
	}

	public ArrayList<Flight> filter(ArrayList<Flight> list) {
		ArrayList<Flight> filtered = new ArrayList<Flight>();

		for (Flight f : list) {
			if (f.getCost() <= this.limit) {
				filtered.add(f);
			}
		}
		return filtered;
	}

}
