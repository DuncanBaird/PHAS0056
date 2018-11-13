package midterm2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Players {

	// member variables
	
	private String playerName;
	private String team;
	private String playerPosition;
	private int numberGames;
	private int atBats;
	private int totalRuns;
	private int hits;
	private int doubles;
	private int triples;
	private int homeRuns;
	private int runsBattedIn;
	private double battingAverage;
	private double onBasePercentage;

	//// constructors
	
	public Players() {
		this.playerName = "";
		this.team = "";
		this.playerPosition = "";
		this.numberGames = 0;
		this.atBats = 0;
		this.totalRuns = 0;
		this.hits = 0;
		this.doubles = 0;
		this.triples = 0;
		this.homeRuns = 0;
		this.runsBattedIn = 0;
		this.battingAverage = 0.0d;
		this.onBasePercentage = 0.0d;
	}

	public Players(String playerName, String team, String playerPosition, int numberGames, int atBats, int totalRuns,
			int hits, int doubles, int triples, int homeRuns, int runsBattedIn, double battingAverage,
			double onBasePercentage) {
		this.playerName = playerName;
		this.team = team;
		this.playerPosition = playerPosition;
		this.numberGames = numberGames;
		this.atBats = atBats;
		this.totalRuns = totalRuns;
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.homeRuns = homeRuns;
		this.runsBattedIn = runsBattedIn;
		this.battingAverage = battingAverage;
		this.onBasePercentage = onBasePercentage;
	}

	// get methods
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @return the playerPosition
	 */
	public String getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * @return the numberGames
	 */
	public int getNumberGames() {
		return numberGames;
	}

	/**
	 * @return the atBats
	 */
	public int getAtBats() {
		return atBats;
	}

	/**
	 * @return the totalRuns
	 */
	public int getTotalRuns() {
		return totalRuns;
	}

	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @return the doubles
	 */
	public int getDoubles() {
		return doubles;
	}

	/**
	 * @return the triples
	 */
	public int getTriples() {
		return triples;
	}

	/**
	 * @return the homeRuns
	 */
	public int getHomeRuns() {
		return homeRuns;
	}

	/**
	 * @return the runsBattedIn
	 */
	public int getRunsBattedIn() {
		return runsBattedIn;
	}

	/**
	 * @return the battingAverage
	 */
	public double getBattingAverage() {
		return battingAverage;
	}

	/**
	 * @return the onBasePercentage
	 */
	public double getOnBasePercentage() {
		return onBasePercentage;
	}

	// toString
	@Override
	public String toString() {
		return "Players [playerName=" + playerName + ", team=" + team + ", playerPosition=" + playerPosition
				+ ", numberGames=" + numberGames + ", atBats=" + atBats + ", totalRuns=" + totalRuns + ", hits=" + hits
				+ ", doubles=" + doubles + ", triples=" + triples + ", homeRuns=" + homeRuns + ", runsBattedIn="
				+ runsBattedIn + ", battingAverage=" + battingAverage + ", onBasePercentage=" + onBasePercentage
				+ "]\n";
	}


	// get data from URL
	// reads URL and returns data as BufferedReader object

	// create array list from URL inputed data
	public static ArrayList<Players> dataFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		// create array list
		ArrayList<Players> array1 = new ArrayList<Players>();

		for (int i = 0; i < 2; i++) {
			br.readLine();
		}

		// adds tokens from URL to array list
		while ((line = br.readLine()) != null) {
			Players player = Players.parseLine(line);
			array1.add(player);
		}
		return array1;
	}

	// parser
	public static Players parseLine(String line) {
		Players p = new Players();
		Scanner s = new Scanner(line);
		s.useDelimiter("\t");

		while (s.hasNext()) {
			p.playerName = s.next();
			p.team = s.next();
			p.playerPosition = s.next();
			if (s.hasNextInt()) {
				p.numberGames = s.nextInt();
				p.atBats = s.nextInt();
				p.totalRuns = s.nextInt();
				p.hits = s.nextInt();
				p.doubles = s.nextInt();
				p.triples = s.nextInt();
				p.homeRuns = s.nextInt();
				p.runsBattedIn = s.nextInt();
				p.battingAverage = s.nextDouble();
				p.onBasePercentage = s.nextDouble();
			}
		}
		s.close();
		return p;
	}

	public static double slugPC(Players p) {
		double SLG_t = (p.hits) + (2 * p.doubles) + (3 * p.triples) + (4 * p.homeRuns);
		double SLG_b = p.atBats;
		return SLG_t / SLG_b;
	}

	public static double slugTime(Players p) {
		return slugPC(p) + p.onBasePercentage;
	}

}
