package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	// member variables
	private String playerName;
	private String team;
	private String playerPosition;
	private int numberGames;
	private int rushAttempts;
	private int rushYards;
	private int rushTouchDowns;
	private int target;
	private int receptions;
	private int receivingYards;
	private int receivingTouchDowns;
	private int fumbles;

	//// constructors
	public Player() {
		this.playerName = "";
		this.team = "";
		this.playerPosition = "";
		this.numberGames = 0;
		this.rushAttempts = 0;
		this.rushYards = 0;
		this.rushTouchDowns = 0;
		this.target = 0;
		this.receptions = 0;
		this.receivingYards = 0;
		this.receivingTouchDowns = 0;
		this.fumbles = 0;
	}

	public Player(String playerName, String team, String playerPosition, int numberGames, int rushAttempts,
			int rushYards, int rushTouchDowns, int target, int receptions, int receivingYards, int receivingTouchDowns,
			int fumbles) {
		this.playerName = playerName;
		this.team = team;
		this.playerPosition = playerPosition;
		this.numberGames = numberGames;
		this.rushAttempts = rushAttempts;
		this.rushYards = rushYards;
		this.rushTouchDowns = rushTouchDowns;
		this.target = target;
		this.receptions = receptions;
		this.receivingYards = receivingYards;
		this.receivingTouchDowns = receivingTouchDowns;
		this.fumbles = fumbles;
	}

	//// get methods for each member variable

	public String getPlayerName() {
		return playerName;
	}

	public String getTeam() {
		return team;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public int getNumberGames() {
		return numberGames;
	}

	public int getRushAttempts() {
		return rushAttempts;
	}

	public int getRushYards() {
		return rushYards;
	}

	public int getRushTouchDowns() {
		return rushTouchDowns;
	}

	public int getTarget() {
		return target;
	}

	public int getReceptions() {
		return receptions;
	}

	public int getReceivingYards() {
		return receivingYards;
	}

	public int getReceivingTouchDowns() {
		return receivingTouchDowns;
	}

	public int getFumbles() {
		return fumbles;
	}

	// For printing player details
	@Override
	public String toString() {
		return "[Player Name=" + playerName + ", Team=" + team + ", Position=" + playerPosition + ", Number of games="
				+ numberGames + ", Rushing attempts=" + rushAttempts + ", Rushing yards=" + rushYards
				+ ", Rushing touch downs=" + rushTouchDowns + ", Receiving targets=" + target + ", Receptions="
				+ receptions + ", Receiving yards=" + receivingYards + ", Receiving touch downs=" + receivingTouchDowns
				+ ", Fumbles="
				+ fumbles + "]";
	}

	// parser for NFL data
	public static Player parseLine(String line) {
		Player p = new Player();
		Scanner s = new Scanner(line);
		s.useDelimiter("\t");// tab as delimiter

		while (s.hasNext()) {
			p.playerName = s.next();
			p.team = s.next();
			p.playerPosition = s.next();
			if (s.hasNextInt()) {
				p.numberGames = s.nextInt();
				p.rushAttempts = s.nextInt();
				p.rushYards = s.nextInt();
				p.rushTouchDowns = s.nextInt();
				p.target = s.nextInt();
				p.receptions = s.nextInt();
				p.receivingYards = s.nextInt();
				p.receivingTouchDowns = s.nextInt();
				p.fumbles = s.nextInt();
			}
		}
		s.close();
		return p;
	}

	// reads URL and returns data as ArraryList
	public static ArrayList<Player> dataFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		// create array list
		ArrayList<Player> array1 = new ArrayList<Player>();

		// skip 3 header lines
		for (int i = 0; i < 3; i++) {
			br.readLine();
		}

		// adds tokens from URL to array list
		while ((line = br.readLine()) != null) {
			Player player = Player.parseLine(line);
			array1.add(player);
		}
		return array1;
	}

	// calculates touches of a player
	// Touches=Rushing Attempts + Times as receiving target
	public static int touches(Player p) {
		return p.rushAttempts + p.target;
	}

	// calculates All Purpose Yards of a player
	// All Purpose = Rushing + Receiving
	public static int allPurpose(Player p) {
		return p.rushYards + p.receivingYards;
	}

	// calculates the liability of a player
	// liability = (Rushing Yards + Receiving Yards)/(Attempts + Receiving Target)
	public static double liability(Player p) throws Exception {
		double lia_t = allPurpose(p);
		double lia_b = p.rushAttempts + p.target;
		if (lia_b == 0) {
			throw new Exception("Cannot divide by 0");
		} else {
			return lia_t / lia_b;
		}
	}
	
	// calculates the Butter Fingers of a player
	// butter fingers= ((Receiving target - Receptions)+ fumbles)/(Receiving
	// target+Attempts)
	public static double butterFingers(Player p) throws Exception {
		double but_t = (p.target - p.receptions) - p.fumbles;
		double but_b = p.target + p.rushAttempts;
		if (but_b == 0) {
			throw new Exception("Cannot divide by 0");
		} else {
			return but_t / but_b;
		}
	}
}
