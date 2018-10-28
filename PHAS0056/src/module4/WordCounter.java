package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	// reads URL and returns data as BufferedReader object
	public static BufferedReader brFromURL(String urlName) 
			throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	// reads file and returns data as BufferedReader object
	public static BufferedReader brFromFile(String fileName)
			throws FileNotFoundException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	// returns the number of words in the input data
	public static int countWordsInResource(BufferedReader dataAsBR) {
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
		// Testing brFromURL method
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
		
		// testing countWordsinResource
		try {
			BufferedReader web = brFromURL(
					"http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/data/module4/module4_text.txt");
			int wordCount = countWordsInResource(web);
			System.out.println("The word count from module4_text.txt"
					+ " is: " + wordCount);
		}
		catch(java.io.IOException e){
			System.out.println(e);
		}
	}
}
