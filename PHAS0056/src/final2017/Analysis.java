package final2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {

	/**
	 * Returns ArrayList of airports from URL input
	 * 
	 * @param url
	 * @return airports
	 * @throws IOException
	 */
	public static HashMap<String, Airport> airportsFromURL(String url) throws IOException {
		HashMap<String, Airport> airports = new HashMap<String, Airport>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// ensures special characters are read correctly by java
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Airport a = Airport.parseLine(line);
			airports.put(a.getCode(), a);
		}
		return airports;

	}

	/**
	 * Returns ArrayList of flights from URL input
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Flight> flightsFromURL(String url) throws IOException {
		ArrayList<Flight> flights = new ArrayList<Flight>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// ensures special characters are read correctly by java
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Flight f = Flight.parseLine(line);
			flights.add(f);
		}
		return flights;

	}
}
