package final2017;

import java.util.ArrayList;
import java.util.Collections;

public class ExamPart3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Flight> allflights = new ArrayList<Flight>();

		try {
			allflights = Analysis
					.flightsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2017-18/flights.txt");

			FlightFilter f1 = new TwoStageFlights("LHR", "CPT");
			FlightFilter f2 = new SpecifyAirports("LHR", "CPT");
			FlightFilter f3 = new SpecifyDuration(24);

			ArrayList<Flight> filteredTwoStage = f1.filter(allflights);
			ArrayList<Flight> filteredOneStage = f2.filter(allflights);

			ArrayList<Flight> merged = new ArrayList<Flight>();
			merged.addAll(filteredOneStage);
			merged.addAll(filteredTwoStage);

			ArrayList<Flight> mergedFiltered = f3.filter(merged);

			System.out.println("Flights from LHR to CPT with 2 stages:");
			for (Flight f : filteredTwoStage) {
				System.out.println(f);
			}
			System.out.println("\nFlights from LHR to CPT that are direct:");
			for (Flight f : filteredOneStage) {
				System.out.println(f);
			}
			System.out.println("\nFlights from LHR to CPT that are less than 24 hours:");
			for (Flight f : mergedFiltered) {
				System.out.println(f);
			}
			System.out.println("\nFlight from LHR to CPT that is cheapest:");
			System.out.println(Collections.min(mergedFiltered, new FlightCompCost()));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
