package midterm2016;

import java.util.ArrayList;
import java.util.HashMap;

public class MidTermExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Players> players = new ArrayList<Players>();

		try {

			// import data from URL
			players = Players
					.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt");
			HashMap<String, ArrayList<Players>> teams = new HashMap<String, ArrayList<Players>>();

			// create arraylist of teams
			for (Players player : players) {
				String currentTeam = player.getTeam();
				ArrayList<Players> currentPlayers = teams.get(currentTeam);
				if (currentPlayers == null) {
					teams.put(currentTeam, new ArrayList<Players>());
				}
				teams.get(currentTeam).add(player);
			}

			int maxRuns = 0;
			int playerMaxRunsUUID = 0;

			// find player with max runs
			for (int i = 0; i < players.size(); i++) {
				if (maxRuns < players.get(i).getHomeRuns()) {
					maxRuns = players.get(i).getHomeRuns();
					playerMaxRunsUUID = i;
				}
			}

			System.out.println("Totol # of players is " + players.size());
			System.out.println("Most home runs is" + maxRuns);
			System.out.println("The player stats are; " + players.get(playerMaxRunsUUID));
			
			
			// 10 plus at Bats
			HashMap<String, ArrayList<Players>> tenAtBats = new HashMap<String, ArrayList<Players>>();
			
			// finds players with >10 AB
			for(String team: teams.keySet()) {
				for (Players player : teams.get(team)) {
					ArrayList<Players> currentPlayers = tenAtBats.get(team);
					if (currentPlayers == null) {
						tenAtBats.put(team, new ArrayList<Players>());

					}
					if (player.getAtBats() >= 10) {
						tenAtBats.get(team).add(player);
					}
				}
			}
			
			// finds SLG and OPS for players with >10 AB
			for (String team : tenAtBats.keySet()) {
				int total = tenAtBats.get(team).size();
				System.out.println("Total at Bats for " + team + " is; " + total);
				double slugPC = 0.0d;
				double slugTime = 0.0d;
				for (Players player : tenAtBats.get(team)) {
					if (Players.slugPC(player) > slugPC) {
						slugPC = Players.slugPC(player);
					}
					if (Players.slugTime(player) > slugTime) {
						slugTime = Players.slugTime(player);
					}
				}

				System.out.println("The highest SLG for " + team + " was " + slugPC);
				System.out.println("Highest OPS for " + team + " was " + slugTime);
			}


			// System.out.println(players.get(0) + "words" + players.get(1));
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

}
