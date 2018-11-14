package exam1;

import java.util.ArrayList;
import java.util.HashMap;

public class MidTermExam {

	public static void main(String[] args) {
		//// Analysis of NFL player data

		// create ArrayList collection for storying player data
		ArrayList<Player> players = new ArrayList<Player>();

		try { // try analysis

			// import data and assign to ArrayList from URL
			players = Player.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt");

			// create HashMap of players ArrayList
			HashMap<String, ArrayList<Player>> teams = new HashMap<String, ArrayList<Player>>();
			// create ArrayList of teams
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

			System.out.println("The total number of players recorded in the file is: " + players.size());
			
			System.out.println("The player with the maximum number of rushing yards "
					+ "is:" + players.get(playerMaxRushingYardsUUID));

			System.out.println("The player with the maximum number of all purpose yards " + "is:"
					+ players.get(playerMaxAllPurposeYardsUUID));
			
			//// For each team

			// Players with more than 10 touches
			HashMap<String, ArrayList<Player>> tenPlusTouches = new HashMap<String, ArrayList<Player>>();
			
			for (String team : teams.keySet()) { // loops over teams
				for (Player player : teams.get(team)) { // loops over players in team
					ArrayList<Player> currentPlayers = tenPlusTouches.get(team);
					if(currentPlayers == null) {
						tenPlusTouches.put(team, new ArrayList<Player>());
					}
					if (Player.touches(player) >= 10) {
						// add player details if touches are sufficient
						tenPlusTouches.get(team).add(player);
					}
				}
				System.out.println("The number of players with more than ten touches for " + team + " is: "
						+ tenPlusTouches.get(team).size());
			}

			// calculating player with greatest liability per team
			
			HashMap<String, ArrayList<Player>> largestLiability = new HashMap<String, ArrayList<Player>>();
			double maxLiability = 0.0d;
			for (String team : teams.keySet()) { // loops over teams
				for (Player player : teams.get(team)) { // loops over players
					ArrayList<Player> currentPlayers = largestLiability.get(team);
					if (currentPlayers == null) {
						largestLiability.put(team, new ArrayList<Player>());
					}
					largestLiability.get(team).add(player);
					if (maxLiability < Player.liability(player)) {
						maxLiability = Player.liability(player);
						// if liability is higher update ArrayList
						largestLiability.get(team).set(0, player);
						}
					}
				System.out.println("The player with the highest liability for " + team + " is: "
						+ largestLiability.get(team).get(0));
			}
			
			// calculating player with max butter fingers per team
			HashMap<String, ArrayList<Player>> largestButter = new HashMap<String, ArrayList<Player>>();
			double maxButter = 0.0d;
			// loops over teams that have a player with at least 10 touches
			for (String team : tenPlusTouches.keySet()) {
				// loops over players with at least 10 touches
				for (Player player : tenPlusTouches.get(team)) {
					ArrayList<Player> currentPlayers = largestButter.get(team);
					if (currentPlayers == null) {
						largestButter.put(team, new ArrayList<Player>());
					}
					largestButter.get(team).add(player);
					if (maxButter < Player.butterFingers(player)) {
						maxButter = Player.butterFingers(player);
						// if butter fingers is higher update ArrayList
						largestButter.get(team).set(0, player);
					}
				}
				System.out.println(
						"The player with the highest butter finger for " + team + " is: "
								+ largestButter.get(team).get(0));
			}

		} catch (Exception e) {
			// if exception is thrown catch
			// analysis contained in 1 try as pointless to continue
			// if there is an exception
			System.out.println(e);
		}
	}
}
