package exam2;

import java.util.HashMap;
import java.util.Map.Entry;

public class ExamPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Location> locations = new HashMap<Integer, Location>();
		try {
			locations = Analysis
					.locationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
			for (Entry<Integer, Location> entry : locations.entrySet()) {
				System.out.println(entry);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
