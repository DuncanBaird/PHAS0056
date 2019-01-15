package final2017;

import java.util.Comparator;

public class FlightCompCost implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {
		if (o1.getCost() < o2.getCost()) {
			return -1;
		}
		if (o1.getCost() == o2.getCost()) {
			return 0;
		} else {
			return 1;
		}
	}

}
