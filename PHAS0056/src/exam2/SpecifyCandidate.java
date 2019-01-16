package exam2;

import java.util.ArrayList;

public class SpecifyCandidate implements ImageSelector {

	String species;

	public SpecifyCandidate(String species) {
		this.species = species;
	}

	public ArrayList<Location> select(ArrayList<Location> locations) {
		// TODO Auto-generated method stub
		ArrayList<Location> filtered = new ArrayList<Location>();
		for (Location l : locations) {
			int j = 0;
			if (Location.findSpecies(l.getImageUUID()).equals(this.species)) {
				j++;
				if (j > (locations.size() / 2)) {
					filtered.add(l);
				}

			}
		}
		return filtered;
	}

}
