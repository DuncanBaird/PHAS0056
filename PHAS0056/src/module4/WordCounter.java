package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

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
		// returns the number of words in the input data
		Scanner s = new Scanner(dataAsBR);
		int wordCount = 0;
		while (s.hasNext()) {
			wordCount ++;
			s.next();
		}
		s.close();
		return wordCount;
	}
	
	public static void main(String[] args) {
		// Testing above methods
		try {
			BufferedReader web = brFromURL(
					"http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/data/module4/module4_text.txt");
			String line; 
			while ((line = web.readLine()) != null) {
			        System.out.println(line);
			}
		}
		catch(java.io.IOException e){
			System.out.println(e);
		}		
	}
}
