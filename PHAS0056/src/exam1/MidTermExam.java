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
					ArrayList<Player> currentPlayers = tenPlusTouches.get(team);
					if(currentPlayers == null) {
						tenPlusTouches.put(team, new ArrayList<Player>());
					}
					if (Player.touches(player) >= 10) {
						tenPlusTouches.get(team).add(player);
					}
				}
			}
			
			for (String team : tenPlusTouches.keySet()) {
				System.out.println("The number of players with more than ten touches for " + team + " is: "
						+ tenPlusTouches.get(team).size());
				/*
				 * System.out.println("The player with the highest liability for " + team +
				 * " is: " + players.get(playerMaxLiabilityUUID));
				 */
			}
			
			// greatest liability
			
			HashMap<String, ArrayList<Player>> largestLiability = new HashMap<String, ArrayList<Player>>();
			double maxLiability = 0.0d;
			for (String team : teams.keySet()) {
				for (Player player : teams.get(team)) {
					ArrayList<Player> currentPlayers = largestLiability.get(team);
					// System.out.println(player.getPlayerName());
					if (currentPlayers == null) {
						largestLiability.put(team, new ArrayList<Player>());
					}
					largestLiability.get(team).add(player);
					if (maxLiability < Player.liability(player)) {
							maxLiability = Player.liability(player);
						largestLiability.get(team).set(0, player);
						}
					}
				System.out.println("The player with the highest liability for " + team + " is: "
						+ largestLiability.get(team));
			}
			
			// butter fingers
			HashMap<String, ArrayList<Player>> largestButter = new HashMap<String, ArrayList<Player>>();
			double maxButter = 0.0d;
			for (String team : tenPlusTouches.keySet()) {
				for (Player player : tenPlusTouches.get(team)) {
					ArrayList<Player> currentPlayers = largestButter.get(team);
					// System.out.println(player.getPlayerName());
					if (currentPlayers == null) {
						largestButter.put(team, new ArrayList<Player>());
					}
					largestButter.get(team).add(player);
					if (maxButter < Player.butterFingers(player)) {
						maxButter = Player.butterFingers(player);
						largestButter.get(team).set(0, player);
					}
				}
				System.out.println(
						"The player with the highest butter finger for " + team + " is: " + largestButter.get(team));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
