package final2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Analysis {

	/**
	 * Returns ArrayList of airports from URL input
	 * 
	 * @param url
	 * @return airports
	 * @throws IOException
	 */
	public static ArrayList<Airport> airportsFromURL(String url) throws IOException {
		ArrayList<Airport> airports = new ArrayList<Airport>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// ensures special characters are read correctly by java
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Airport a = Airport.parseLine(line);
			airports.add(a);
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

	public static String airportName(ArrayList<Airport> airports, String code) {
		String name = "";
		for (Airport a : airports) {
			if (a.getCode().equals(code)) {
				name = a.getName();
			}
		}
		return name;
	}

}
