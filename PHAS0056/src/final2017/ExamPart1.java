package final2017;

import java.util.ArrayList;

public class ExamPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Flight> flights = new ArrayList<Flight>();
		try {
			flights = Analysis
					.flightsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2017-18/flights.txt");

			for (Flight flight : flights) {
				System.out.println(flight);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
