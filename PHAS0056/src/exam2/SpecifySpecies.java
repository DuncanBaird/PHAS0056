package exam2;

import java.util.ArrayList;

/**
 * Class implementing ImageSelector for filtering by specifying a species
 * 
 * @author Duncan
 *
 */
public class SpecifySpecies implements ImageSelector {

	/**
	 * Member variable
	 */
	String species;

	/**
	 * Constructor for filtering
	 * 
	 * @param species
	 */
	public SpecifySpecies(String species) {
		this.species = species;
	}

	/**
	 * Method for filtering images based on species match to expert identification
	 */
	public ArrayList<Location> select(ArrayList<Location> locations) {
		ArrayList<Location> filtered = new ArrayList<Location>();
		for (Location l : locations) {
			if (Location.findSpecies(l.getImageUUID()).equals(this.species)) {
				filtered.add(l);
			}
		}
		return filtered;
	}

}
