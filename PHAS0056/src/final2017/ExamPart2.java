package final2017;

import java.util.ArrayList;
import java.util.Collections;

public class ExamPart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Flight> allflights = new ArrayList<Flight>();

		try {
			allflights = Analysis
					.flightsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2017-18/flights.txt");

			FlightFilter f1 = new SpecifyAirports("LHR", "ATH");
			FlightFilter f2 = new SpecifyDuration(4);
			FlightFilter f3 = new SpecifyCost(200);

			ArrayList<Flight> filteredLocation = f1.filter(allflights);
			ArrayList<Flight> filteredLocationCost = f3.filter(filteredLocation);
			ArrayList<Flight> filteredLocationDuration = f2.filter(filteredLocation);

			System.out.println("Flights from LHR to ATH that cost no more than £200:");
			for (Flight f : filteredLocationCost) {
				System.out.println(f);
			}
			System.out.println("\nFlights from LHR to ATH that take no more than four hours:");
			for (Flight f : filteredLocationDuration) {
				System.out.println(f);
			}
			System.out.println("\nFastest flight from LHR to ATH that costs no more than £200:");
			System.out.println(Collections.min(filteredLocationCost, new FlightCompTime()));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
