package module4;

import java.io.*;
import java.net.URL;

public class WordCounter {

	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
