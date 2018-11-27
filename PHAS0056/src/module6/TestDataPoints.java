package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class TestDataPoints {

	// create array list from URL inputed data
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		// create array list
		ArrayList<DataPoint> array1 = new ArrayList<DataPoint>();

		// adds tokens from URL to array list
		while ((line = br.readLine()) != null) {
			DataPoint dp = DataPoint.parseLine(line);
			array1.add(dp);
		}
		return array1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
