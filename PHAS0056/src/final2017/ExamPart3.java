package final2017;

import java.util.ArrayList;

public class ExamPart3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Flight> allflights = new ArrayList<Flight>();

		try {
			allflights = Analysis
					.flightsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2017-18/flights.txt");

			FlightFilter f1 = new TwoStageFlights("LHR", "CPT");
			FlightFilter f2 = new SpecifyAirports("LHR", "CPT");

			ArrayList<Flight> filteredTwoStage = f1.filter(allflights);
			ArrayList<Flight> filteredOneStage = f2.filter(allflights);

			System.out.println("Flights from LHR to CPT with 2 stages:");
			for (Flight f : filteredTwoStage) {
				System.out.println(f);
			}
			System.out.println("\nFlights from LHR to CPT that are direct:");
			for (Flight f : filteredOneStage) {
				System.out.println(f);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
