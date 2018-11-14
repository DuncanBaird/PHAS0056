package exam1;

public class midtermtesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Analysis.analysis("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
