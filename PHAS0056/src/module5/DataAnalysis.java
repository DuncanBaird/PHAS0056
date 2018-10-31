package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DataAnalysis {

	//create array list from URL inputed data
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line ="";
		
		//create array list
		ArrayList<DataPoint> array1 = new ArrayList<DataPoint>();
		
		//adds tokens from URL to array list
		while((line=br.readLine()) != null) {
			DataPoint dp = DataPoint.parseLine(line);
			array1.add(dp);
		}
		return array1;
	}
	
	//returns chi squared value of fit
	public static double goodnessOfFit(Theory theory, ArrayList<DataPoint> array1) {
		double chi2 = 0.0d;
		
		//loop over array list for all tokens
		Iterator<DataPoint> it = array1.iterator();
		while(it.hasNext()) {
			DataPoint dp = it.next();
			chi2 += Math.pow(dp.gety()-theory.y(dp.getx()), 2)/Math.pow(dp.getey(), 2);	
		}
		return chi2;
	}
	
	public static void main(String[] args) {
		// testing
		
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();
		
		try {
			data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			//System.out.println("The data is\n" + data.toString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//create theory objects for n=2 and n=4
		Theory n2 = new Theory(2);
		Theory n4 = new Theory(4);
		System.out.println("The chi squared for n = 2 is: " + goodnessOfFit(n2,data));
		System.out.println("The chi squared for n = 4 is: " + goodnessOfFit(n4,data));
		

	}

}
