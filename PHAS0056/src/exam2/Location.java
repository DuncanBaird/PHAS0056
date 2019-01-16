package exam2;

import java.util.ArrayList;
import java.util.Scanner;

public class Location {

	private int imageUUID;
	private double latitude;
	private double longitude;

	public Location() {
		
	}

	public Location(int imageUUID, double latitude, double longitude) {
		this.imageUUID = imageUUID;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
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
