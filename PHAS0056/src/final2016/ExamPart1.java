package final2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Class for running audio analysis for part one of exam Prints out details of
 * audio files from URL source
 * 
 * @author Duncan
 *
 */
public class ExamPart1 {

	/**
	 * Method for pulling audio file data from URL and storing info of data into
	 * ArrayList
	 * 
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Audio> dataFromURL(String dir) throws IOException {
		ArrayList<Audio> sounds = new ArrayList<Audio>();
		URL u = new URL(dir + "index.txt");
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Audio a = Audio.parseNames(line);
			sounds.add(a);
		}
		for (Audio sound : sounds) {
			ArrayList<Integer> data = Audio.parseData(dir + sound.getFilename());
			sound.setF(data.get(0));
			sound.setN(data.get(1));
			sound.setMaxA(data.get(2));

			for (int i = 0; i < 3; i++) {
				data.remove(0);
			}
			sound.setDataPoints(data);
		}
		return sounds;
	}

	/**
	 * Main method for running analysis
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Audio> sounds = new ArrayList<Audio>();

		try {
			sounds = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/");
			for (Audio sound : sounds) {
				System.out.println(sound);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
