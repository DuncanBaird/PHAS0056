package final2016;

import java.util.ArrayList;

public class Audio {

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
		return "Audio [filename=" + filename + ", instrument=" + instrument + ", f=" + f + ", N=" + N + ", maxA=" + maxA
				+ "]";
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

}
