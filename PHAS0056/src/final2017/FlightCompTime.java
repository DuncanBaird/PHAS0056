package final2017;

import java.util.Comparator;

public class FlightComp implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {
		if (o1.flightTime() < o2.flightTime()) {
			return -1;
		}
		if (o1.flightTime() == o2.flightTime()) {
			return 0;
		} else {
			return 1;
		}
	}

}
