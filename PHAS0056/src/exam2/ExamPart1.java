package exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ExamPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Location> locations = new HashMap<Integer, Location>();
		ArrayList<Classification> classifications = new ArrayList<Classification>();
		

		try {
			locations = Analysis
					.locationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
			System.out.println("Total number of images: " + locations.size());
			
			classifications = Analysis.classificationsFromURL(
					"http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
			

			System.out.println(
					"The number of images classified by atleast one volunteer is: "
							+ Analysis.classificationFrequency(0, locations, classifications).size());
			

			for (Entry<Integer, Location> entry : locations.entrySet()) {
				System.out.println(entry);
			}
			
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
