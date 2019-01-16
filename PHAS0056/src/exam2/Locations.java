package exam2;

public class Locations {

	private int imageUUID;
	private double latitude;
	private double longitude;

	public Locations() {
		
	}

	public Locations(int imageUUID, double latitude, double longitude) {
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
		return "Locations [imageUUID=" + imageUUID + ", latitude=" + latitude + ", longitude=" + longitude + "]";
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

}
