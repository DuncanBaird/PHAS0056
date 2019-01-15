package final2017;

import java.util.ArrayList;
import java.util.Collection;

public class SpecifyCost implements FlightFilter {

	@Override
	public Collection<Flight> filter(Collection<Flight> flights, Criterion c) {
		// TODO Auto-generated method stub
		Collection<Flight> filteredFlights = new ArrayList<Flight>();
		for (Flight f : flights) {
			if (f.getCost() <= c.getCost()) {
				filteredFlights.add(f);
			}
		}
		return null;
	}

}
