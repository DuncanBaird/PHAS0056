package exam1;

import java.util.ArrayList;

public class MidTermExam {

	public static void main(String[] args) {
		// Analysis of NFL player data

		// create ArrayList collection for storying player data
		ArrayList<Player> players = new ArrayList<Player>();

		try {
			players = Player.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
