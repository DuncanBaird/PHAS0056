package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class Analysis {

	/**
	 * Returns HashMap of locations from URL input
	 * 
	 * @param url
	 * @return airports
	 * @throws IOException
	 */
	public static HashMap<Integer, Location> locationsFromURL(String url) throws IOException {
		HashMap<Integer, Location> locations = new HashMap<Integer, Location>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Location l = Location.parseLine(line);
			locations.put(l.getImageUUID(), l);
		}
		return locations;

	}

}
