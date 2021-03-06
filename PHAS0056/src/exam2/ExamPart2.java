package exam2;

import java.util.ArrayList;

/**
 * Class for answering part 2 in exam
 * 
 * @author
 *
 */
public class ExamPart2 {

	/**
	 * Main method for filtering image data by species
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Location> locations = new ArrayList<Location>();

		try {
			locations = Analysis
					.arrayLocationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
			ImageSelector s1 = new SpecifySpecies("lion");
			System.out.println("Starting lion image selection(slow): ");
			ArrayList<Location> filteredLocations = s1.select(locations);
			System.out.println("All images identified as lions: ");
			for (Location l : filteredLocations) {
				System.out.println(l);
			}


			ImageSelector s2 = new SpecifyCandidate("lion");
			System.out.println("Starting lion candidate check: ");
			ArrayList<Location> filteredCandidates = s2.select(locations);
			for (Location l : filteredCandidates) {
				System.out.println(l);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
