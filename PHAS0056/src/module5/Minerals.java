package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Minerals {

	// member variables
	private int UUID;
	private double mass;
	private String nameLoc;

	//// Constructors

	public Minerals() {
		UUID = 0;
		mass = 0.0d;
		nameLoc = "";
	}

	public Minerals(int UUID, double mass) {
		this.UUID = UUID;
		this.mass = mass;
	}

	public Minerals(int UUID, String nameLoc) {
		this.UUID = UUID;
		this.nameLoc = nameLoc;
	}

	//// get methods for member variables
	public int getUUID() {
		return UUID;
	}

	public double getMass() {
		return mass;
	}

	public String getNameLoc() {
		return nameLoc;
	}

	// Parser for input string
	public static Minerals parseLine(String line) {
		Scanner s = new Scanner(line);
		int UUID = 0;
		double mass = 0.0d;
		String nameLoc = "";
		Minerals mineral = new Minerals();
		// iterate over input tokens
		while (s.hasNext()) {
			// if type integer -> UUID
			if (s.hasNextInt()) {
				UUID = s.nextInt();
				mass = s.nextDouble();
				mineral = new Minerals(UUID, mass);
			}
			// if other type comes first -> nameLoc
			else {
				nameLoc = s.next();
				UUID = s.nextInt();
				mineral = new Minerals(UUID, nameLoc);
			}
		}
		s.close();
		return mineral;
	}

	// hash maps
	public static HashMap<Integer, String> massHashMap(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

		// adds tokens from URL to hash map
		while ((line = br.readLine()) != null) {
			Minerals mineral = parseLine(line);
			hashmap.put(mineral.getUUID(), mineral.getNameLoc());
		}
		return hashmap;

	}

	public static HashMap<Integer, Double> nameHashMap(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		HashMap<Integer, Double> hashmap = new HashMap<Integer, Double>();

		// adds tokens from URL to hash map
		while ((line = br.readLine()) != null) {
			Minerals mineral = parseLine(line);
			hashmap.put(mineral.getUUID(), mineral.getMass());
		}
		return hashmap;

	}

}
