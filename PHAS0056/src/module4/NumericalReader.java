package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {

    private double minValue;
    private double maxValue;
    private int nValues;
    private double sumOfValues;
    public String fileLoc;
	
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
	
	void analysisStart(String dataFile) throws IOException {
		// Writes file in path
		File outputfile = new File(dataFile);
	    FileWriter fw = new FileWriter(outputfile);
	    fw.close();
	    minValue = 0;
		maxValue = 0;
		nValues = 0;
		sumOfValues = 0;
	}
	
	void analyseData(String line) throws IOException {
		Scanner s = new Scanner(line);
	    BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileLoc, true));

	    while (s.hasNext()) { // Checks for remaining tokens

	      if (s.hasNextDouble()) {
	        Double number = s.nextDouble();
	        System.out.println(number);
	        String numberAsString = Double.toString(number);
	        bw.write(numberAsString); // Writes string representation of double to file
	        bw.newLine();
	        this.nValues++; // Updates variables
	        this.sumOfValues += number;

	        if (this.minValue > number) { // Updates min/max if a token is less/more than current value
	          this.minValue = number;
	        } else if (this.maxValue < number) {
	          this.maxValue = number;
	        }
	      }

	      else if (s.hasNextInt()) { // Works same as for doubles
	        int number = s.nextInt();
	        System.out.println(number);
	        bw.write(number);
	        bw.newLine();
	        this.nValues++;
	        this.sumOfValues += number;

	        if (this.minValue > number) {
	          this.minValue = number;
	        } else if (this.maxValue < number) {
	          this.maxValue = number;
	        }
	      } else { // Goes to new line for non-numbers
	        s.nextLine();
	      }

	    }
	    s.close();
	    bw.close();
	}
	
	void analysisEnd() {
		System.out.println("The min value is " + this.minValue);
		System.out.println("The max value is " + this.maxValue);
		System.out.println("The mean value is " + this.sumOfValues/nValues);
		System.out.println("The total number of values read is " + this.sumOfValues );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 NumericalReader numRead_1 = new NumericalReader();
		 String dataFile = ("N:" + File.separator + "mywork"
		 + File.separator + "numbers.txt");
		 
	}

}
