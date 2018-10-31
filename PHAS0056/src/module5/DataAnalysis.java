package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
		while((line=br.readLine()) != null) {
			DataPoint dp = DataPoint.parseLine(line);
			array1.add(dp);
		}
		return array1;
	}
	
	//returns chi squared value of fit
	public static double goodnessOfFit(Theory theory, ArrayList<DataPoint> array1) {
		double chi2 = 0.0d;
		Iterator<DataPoint> it = array1.iterator();
		while(it.hasNext()) {
			DataPoint dp = it.next();
			chi2 += Math.pow(dp.gety()-theory.y(dp.getx()), 2)/Math.pow(dp.getey(), 2);
			
		}
		return chi2;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
