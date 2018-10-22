package module4;

import java.io.*;
import java.net.*;

public class WordCounter {

	public static BufferedReader brFromURL(String urlName) 
			throws IOException {
		// reads URL and returns data as BufferedReader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	public static BufferedReader brFromFile(String fileName)
			throws FileNotFoundException {
		// reads file and returns data as BufferedReader object
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	public static int countWordsInResource(BufferedReader dataAsBR) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
