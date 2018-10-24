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
	
    // ask user to input file directory for program
	public static String getStringFromKeyboard()
			throws IOException {
		System.out.println("Enter directory:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		// confirm to user what directory the inputed
		System.out.println("You typed: " + s);
		if (s.length() != 0) {
		      return s;
		    } else {
		      System.out.println("User home directory has been selected.");
		      System.out.println();
		      return System.getProperty("user.home");
		    }
	}

	// reads URL and returns data as BufferedReader object
	public BufferedReader brFromURL(String urlName)
			throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	void analysisStart(String dataFile) throws IOException {
		// Writes file in chosen directory
		File outputfile = new File(dataFile);
	    FileWriter fw = new FileWriter(outputfile);
	    fw.close();
	    // initialise variables
	    minValue = 0;
		maxValue = 0;
		nValues = 0;
		sumOfValues = 0;
	}
	
	void analyseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		// new BufferedWriter object for writing file to file.Loc
	    BufferedWriter bw = new BufferedWriter(
	    		new FileWriter(this.fileLoc, true));
	    // checks next token
	    while (s.hasNext()) {
	    	
		// if token is type integer
	    if (s.hasNextDouble()) { 
	        Double number = s.nextDouble();
	        System.out.println(number);
	        String numberAsString = Double.toString(number);
	        // writes string representation of token
	        bw.write(numberAsString);
	        bw.newLine();
	        // update variables
	        this.nValues++;
	        this.sumOfValues += number;

	        // update min and max if token is different than current
	        if (this.minValue > number) { 
	          this.minValue = number;
	        } else if (this.maxValue < number) {
	          this.maxValue = number;
	        }
	      }

	    // if token is type integer
	    else if (s.hasNextInt()) {
	    	int number = s.nextInt();
	        System.out.println(number);
	        // writes string representation of token
	        bw.write(number);
	        bw.newLine();
	        // update variables
	        this.nValues++;
	        this.sumOfValues += number;
	        
	        // update min and max if token is different than current
	        if (this.minValue > number) {
	          this.minValue = number;
	        } else if (this.maxValue < number) {
	          this.maxValue = number;
	        }
	      } 
	    // Goes to new line for non-numbers
	    else { 
	    	s.nextLine();
	      }
	    }
	    // close resources
	    s.close();
	    bw.close();
	}
	
	// prints results of analysis
	void analysisEnd() {
		System.out.println("The min value is " + this.minValue);
		System.out.println("The max value is " + this.maxValue);
		System.out.println("The mean value is " + this.sumOfValues/nValues);
		System.out.println("The total number of values read is " + this.sumOfValues );
	}
	
	public static void main(String[] args) {
		
		// Uses above methods to analyse data from URLs
		 
		// Creates objects for holding variables
		NumericalReader nr1 = new NumericalReader(); 
		NumericalReader nr2 = new NumericalReader();
		String line = "";
		String saveDir = "";
		try {
			saveDir = NumericalReader.getStringFromKeyboard();
			} 
		catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			nr1.fileLoc = (saveDir + File.separator + "numbers1.txt");
			System.out.println("Saving to " + nr1.fileLoc);
			nr1.analysisStart(nr1.fileLoc);

			// Creates BufferedReader object from a web page
			BufferedReader webBuffer1 = nr1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			// Prints each number until readLine returns a null (empty) line
			while ((line = webBuffer1.readLine()) != null) {
			nr1.analyseData(line);
			}
		} 
		catch (java.io.IOException e) {
			System.out.println(e);
		}
		nr1.analysisEnd(); // Print min, max, average, total
		System.out.println();
		try {
			saveDir = NumericalReader.getStringFromKeyboard();
			} 
		catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			nr2.fileLoc = (saveDir + File.separator + "numbers2.txt");
			System.out.println("Saving to " + nr2.fileLoc);
			nr2.analysisStart(nr2.fileLoc);

			// Creates BufferedReader object from a web page
			BufferedReader webBuffer2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			// Prints each number until readLine returns a null (empty) line
			while ((line = webBuffer2.readLine()) != null) {
			nr2.analyseData(line);
			}
		} 
		catch (java.io.IOException e) {
			System.out.println(e);
		}
		nr1.analysisEnd(); // Print min, max, average, total
		System.out.println();
	}
}
