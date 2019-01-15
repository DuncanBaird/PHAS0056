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
		try {
			ArrayList<Airport> airports = new ArrayList<Airport>(
					Analysis.airportsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2017-18/airports.txt")
							.values());
			for (Airport a : airports) {
				for (Flight f : list) {
					if (f.getOrigin().equals(this.origin) && f.getDestination().equals(a.getCode())) {
						for (Flight j : list) {
							if (j.getOrigin().equals(a.getCode()) && j.getDestination().equals(this.destination)) {
								filtered.add(new Flight("2S", f.getOrigin(), j.getDestination(), f.getDepartureDate(),
										f.getDepartureTime(), j.getArrivalDate(), j.getArrivalTime(), f.getCost()));
							}
						}

					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}


		return filtered;
	}

}
