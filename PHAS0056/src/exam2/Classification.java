package exam2;

import java.util.Scanner;

public class Classification {

	private int imageUUID;
	private String speciesName;

	public Classification() {

	}

	public Classification(int imageUUID, String speciesName) {
		this.imageUUID = imageUUID;
		this.speciesName = speciesName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
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
