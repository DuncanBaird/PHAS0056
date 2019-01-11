package final2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ExamPart1 {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
