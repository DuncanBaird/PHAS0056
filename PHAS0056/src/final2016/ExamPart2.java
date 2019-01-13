package final2016;

import java.util.ArrayList;

/**
 * Class for implementing audio classification system
 * 
 * @author Duncan
 *
 */
public class ExamPart2 {

	/**
	 * Main method for analysing audio with classification system
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Audio> sounds = new ArrayList<Audio>();
		Classify length = new FindLength();
		Classify volume = new FindVolume();

		try {
			sounds = ExamPart1.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/");

			for (Audio sound : sounds) {
				System.out.println(sound);
				System.out.println("Length: " + length.classify(sound));
				System.out.println("Volume: " + volume.classify(sound));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
