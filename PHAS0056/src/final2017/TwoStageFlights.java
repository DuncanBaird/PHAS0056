package final2017;

import java.util.ArrayList;

public class TwoStageFlights implements FlightFilter {

	String origin;
	String destination;
	String Stopover;

	public TwoStageFlights(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> list) {
		// TODO Auto-generated method stub
		ArrayList<Flight> filtered = new ArrayList<Flight>();

		for (Flight f : list) {
			if (f.getOrigin().equals(this.origin) && f.getDestination().equals(this.Stopover)) {
				for (Flight j : list) {
					if (j.getOrigin().equals(this.Stopover) && j.getDestination().equals(this.destination)) {
						filtered.add(f);
						filtered.add(j);
					}
				}

			}
		}
		return filtered;
	}

}
