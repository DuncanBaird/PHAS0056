package module8;

public class CountdownTask implements Runnable {

	int time;

	public CountdownTask(int time) {
		this.time = time;
	}

	public void run() {
		for (int i = this.time; i > -1; i--) {
			System.out.println("Seconds left is: " + i);
		}
	}
}
