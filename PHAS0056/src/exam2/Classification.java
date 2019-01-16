package exam2;

import java.util.Scanner;

/**
 * Class for creating objects to represent classifications of images
 * 
 * @author
 *
 */
public class Classification {

	/**
	 * Member variables
	 */
	private int imageUUID;
	private String speciesName;

	/**
	 * Blank constructor
	 */
	public Classification() {

	}

	/**
	 * Constructor for creating Classification object
	 * 
	 * @param imageUUID
	 * @param speciesName
	 */
	public Classification(int imageUUID, String speciesName) {
		this.imageUUID = imageUUID;
		this.speciesName = speciesName;
	}

	/*
	 * toString method for printing object
	 */
	@Override
	public String toString() {
		return "Classification [imageUUID=" + imageUUID + ", speciesName=" + speciesName + "]";
	}

	/**
	 * @return the imageUUID
	 */
	public int getImageUUID() {
		return imageUUID;
	}

	/**
	 * @return the speciesName
	 */
	public String getSpeciesName() {
		return speciesName;
	}

	/**
	 * Parseline method for parsing string data into construction of classification
	 * object
	 * 
	 * @param line
	 * @return
	 */
	public static Classification parseLine(String line) {
		Scanner s = new Scanner(line);
		Classification c = new Classification();
		if (s.hasNext()) {
			c.imageUUID = s.nextInt();
			s.nextInt();
			c.speciesName = s.next();
		}
		s.close();
		return c;

	}
}
