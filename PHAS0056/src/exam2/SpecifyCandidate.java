package exam2;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecifyCandidate implements ImageSelector {

	String species;

	public SpecifyCandidate(String species) {
		this.species = species;
	}

	public ArrayList<Location> select(ArrayList<Location> locations) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<Classification> classifications = new ArrayList<Classification>();
		classifications = Analysis
				.classificationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");

		HashMap<Integer, Location> images = new HashMap<Integer, Location>();
		images = Analysis.locationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");

		ArrayList<Location> filtered = new ArrayList<Location>();
		ArrayList<Classification> filteredClass = new ArrayList<Classification>();

		for (Classification c : classifications) {
			if (c.getSpeciesName().equals(this.species)) {
				filteredClass.add(c);
			}
		}

		HashMap<Integer, Integer> frequencyClassCorrect = Analysis.classificationFrequency(0, images, filteredClass);
		HashMap<Integer, Integer> frequencyClass = Analysis.classificationFrequency(0, images, classifications);
		for (Integer s : frequencyClassCorrect.keySet()) {
			frequencyClassCorrect.put(s, frequencyClassCorrect.get(s) / 2);

		}


		for (Location l : locations) {
			if (frequencyClassCorrect.get(l.getImageUUID()) != null) {
				System.out.println("suprise" + frequencyClassCorrect.get(l.getImageUUID()));
				if (frequencyClassCorrect.get(l.getImageUUID()) > frequencyClass.get(l.getImageUUID())) {
					System.out.println("suprise");
					filtered.add(l);
				}
			}

		}


		return filtered;
	}

}
