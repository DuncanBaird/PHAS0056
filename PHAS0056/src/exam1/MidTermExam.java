package exam1;

import java.util.ArrayList;
import java.util.HashMap;

public class MidTermExam {

	public static void main(String[] args) {
		// Analysis of NFL player data

		// create ArrayList collection for storying player data
		ArrayList<Player> players = new ArrayList<Player>();

		try { // try analysis

			// import data and assign to ArrayList from URL
			players = Player.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt");

			// create hashmap of players ArrayList
			HashMap<String, ArrayList<Player>> teams = new HashMap<String, ArrayList<Player>>();
			// create arraylist of teams
			for (Player player : players) {
				String currentTeam = player.getTeam();
				ArrayList<Player> currentPlayers = teams.get(currentTeam);
				if (currentPlayers == null) {
					teams.put(currentTeam, new ArrayList<Player>());
				}
				teams.get(currentTeam).add(player);
			}

			int maxRushingYards = 0;
			int playerMaxRushingYardsUUID = 0;
			int maxAllPurposeYards = 0;
			int playerMaxAllPurposeYardsUUID = 0;

			// find player with max rushing yards
			for (int i = 0; i < players.size(); i++) {
				if (maxRushingYards < players.get(i).getRushYards()) {
					maxRushingYards = players.get(i).getRushYards();
					playerMaxRushingYardsUUID = i;
				}
			}
			// find player with max all purpose yards
			for (int i = 0; i < players.size(); i++) {
				if (maxAllPurposeYards < Player.allPurpose(players.get(i))) {
					maxAllPurposeYards = Player.allPurpose(players.get(i));
					playerMaxAllPurposeYardsUUID = i;
				}
			}


			System.out.println(players.get(2));
			System.out.println("The total number of players recorded in the file is: " + players.size());
			
			System.out.println("The player with the maximum number of rushing yards "
					+ "is:" + players.get(playerMaxRushingYardsUUID));

			System.out.println("The player with the maximum number of all purpose yards " + "is:"
					+ players.get(playerMaxAllPurposeYardsUUID));
			
			//// For each team section

			// Players with more than 10 touches
			HashMap<String, ArrayList<Player>> tenPlusTouches = new HashMap<String, ArrayList<Player>>();
			
			// finds players with >10 AB
			for (String team : teams.keySet()) {
				for (Player player : teams.get(team)) {
					ArrayList<Player> currentPlayers = new ArrayList<Player>();

				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
