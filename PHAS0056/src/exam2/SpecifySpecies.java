package exam2;

import java.util.ArrayList;

public class SpecifySpecies implements ImageSelector {

	String species;

	public SpecifySpecies(String species) {
		this.species = species;
	}

	@Override
	public ArrayList<Location> select(ArrayList<Location> locations) {
		// TODO Auto-generated method stub
		ArrayList<Location> filtered = new ArrayList<Location>();
		for (Location l : locations) {
			if (Location.findSpecies(l.getImageUUID()).equals(this.species)) {
				filtered.add(l);
			}
		}
		return filtered;
	}

}
