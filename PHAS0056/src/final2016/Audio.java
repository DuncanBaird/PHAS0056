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

}
