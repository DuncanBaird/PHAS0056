package exam2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for creating objects to represent images taken at locations
 * 
 * @author
 *
 */
public class Location {

	/**
	 * Member variables
	 */
	private int imageUUID;
	private double latitude;
	private double longitude;

	/**
	 * Blank constructor
	 */
	public Location() {
		
	}

	/**
	 * Constructor for Location object to represent image
	 * 
	 * @param imageUUID
	 * @param latitude
	 * @param longitude
	 */
	public Location(int imageUUID, double latitude, double longitude) {
		this.imageUUID = imageUUID;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/*
	 * toString method for Location object. Also finds expert identified species
	 * name to include in print
	 * 
	 */
	@Override
	public String toString() {
		return "Image UUID: " + imageUUID + ", latitude: " + latitude + ", longitude: " + longitude + ", species: "
				+ findSpecies(imageUUID);
	}

	/**
	 * @return the imageUUID
	 */
	public int getImageUUID() {
		return imageUUID;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Parseline method for parsing string data into construction of location object
	 * 
	 * @param line
	 * @return new Location object of an image
	 */
	public static Location parseLine(String line) {
		Scanner s = new Scanner(line);
		Location l = new Location();
		if (s.hasNext()) {
			l.imageUUID = s.nextInt();
			l.latitude = s.nextDouble();
			l.longitude = s.nextDouble();
		}
		s.close();
		return l;

	}

	/**
	 * Method for finding expert species name identification from image UUID. Uses
	 * external data from URL. If data not available it returns a no data statement.
	 * 
	 * @param imageUUID
	 * @return species name or no data statement
	 */
	public static String findSpecies(int imageUUID) {
		ArrayList<Classification> species = new ArrayList<Classification>();
		try {
			species = Analysis
				.classificationsFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");
			return species.get(imageUUID).getSpeciesName();
		} catch (Exception e) {
			return "No species data!";
		}

	}

}
