package final2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for defining AUdio type objects
 * 
 * @author Duncan
 *
 */
public class Audio {

	/**
	 * Member variables
	 */
	private String filename;
	private String instrument;
	private int f;
	private int N;
	private int maxA;
	private ArrayList<Integer> dataPoints;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Filename: " + filename + "; duration: " + this.getT() + " s; " + "amplitude: " + this.getA() + " dBFS"
				+ "; instrument: " + instrument;
	}

	public Audio() {
		this.filename = "";
		this.instrument = "";
		this.f = 0;
		this.N = 0;
		this.maxA = 0;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the instrument
	 */
	public String getInstrument() {
		return instrument;
	}

	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	/**
	 * @return the f
	 */
	public int getF() {
		return f;
	}

	/**
	 * @param f the f to set
	 */
	public void setF(int f) {
		this.f = f;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return N;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		N = n;
	}

	/**
	 * @return the maxA
	 */
	public int getMaxA() {
		return maxA;
	}

	/**
	 * @param maxA the maxA to set
	 */
	public void setMaxA(int maxA) {
		this.maxA = maxA;
	}

	/**
	 * @return the dataPoints
	 */
	public ArrayList<Integer> getDataPoints() {
		return dataPoints;
	}

	/**
	 * @param dataPoints the dataPoints to set
	 */
	public void setDataPoints(ArrayList<Integer> dataPoints) {
		this.dataPoints = dataPoints;
	}

	/**
	 * 
	 * @return time of file in seconds
	 */
	public double getT() {
		return this.N / this.f;
	}

	public double getA() {
		double sum = 0.0d;
		for (int datapoint : this.getDataPoints()) {
			double value = Math.pow(datapoint, 2);
			sum = +value;
		}
		double rms = Math.sqrt(sum / this.N);
		return 20 * Math.log10(rms / this.maxA);
	}

	public double getSpectralDensity(double f) {
		double N = this.getN();
		double t = this.getT();
		double sumCos = 0.0d;
		double sumSin = 0.0d;
		double z = 2 * Math.PI * f * t / N;
		for (int n = 0; n < N; n++) {
			sumCos += this.getDataPoints().get(n) + Math.cos(z * n);
			sumSin += this.getDataPoints().get(n) + Math.sin(z * n);
		}
		double norm = t / Math.pow(N, 2);
		return norm * (Math.pow(sumCos, 2) + Math.pow(sumSin, 2));
	}

	public static Audio parseNames(String line) {
		Audio a = new Audio();
		Scanner s = new Scanner(line);
		if (s.hasNext()) {
			a.filename = s.next();
			a.instrument = s.next();
		}
		s.close();
		return a;
	}

	/**
	 * Method for parsing Audio associated data
	 * 
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Integer> parseData(String urlName) throws IOException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				int number = s.nextInt();
				numbers.add(number);
			}
			s.close();
		}
		return numbers;
	}

}
