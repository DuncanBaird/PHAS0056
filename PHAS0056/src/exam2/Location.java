package exam2;

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
		return "Location [imageUUID=" + imageUUID + ", latitude=" + latitude + ", longitude=" + longitude + "]";
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

	}

}
