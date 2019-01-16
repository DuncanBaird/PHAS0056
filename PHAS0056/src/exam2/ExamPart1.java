package exam2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for answering Part 1 of Exam. Prints total number of images on URL.
 * Prints number of images classified by at least one volunteer. Prints image
 * info for images classified by at least 1o volunteers
 * 
 * @author
 *
 */
public class ExamPart1 {

	/**
	 * Main method for implementing data acquisition and printing data in desired
	 * formats
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Creating collections
		HashMap<Integer, Location> locations = new HashMap<Integer, Location>();
		ArrayList<Classification> classifications = new ArrayList<Classification>();
		

		try {
			// pulling data form URLs
			locations = Analysis
					.locationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
			System.out.println("Total number of images: " + locations.size());
			
			classifications = Analysis.classificationsFromURL(
					"http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
			

			System.out.println(
					"The number of images classified by atleast one volunteer is: "
							+ Analysis.classificationFrequency(0, locations, classifications).size());
			

			System.out.println("The images that were classified at least ten times: ");
			
			for (Integer s : Analysis.classificationFrequency(9, locations, classifications).keySet()) {
				System.out.println(locations.get(s));
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
