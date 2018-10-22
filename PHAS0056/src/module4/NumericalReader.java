package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {

	public static String getStingFromKeyboard()
			throws IOException {
		System.out.println("Enter directory:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		System.out.println("You typed: " + s);
		if (s.length() != 0) {
		      return s;
		    } else {
		      System.out.println("User home directory has been selected.");
		      System.out.println();
		      return System.getProperty("user.home");
		    }
	
	}
	
	public BufferedReader brFromURL(String urlName)
			throws IOException {
		// reads URL and returns data as BufferedReader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	void analysisStart(String dataFile) {
		
	}
	
	void analyseData(String line) {
		
	}
	
	void analysisEnd() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 NumericalReader numRead_1 = new NumericalReader();
	}

}
