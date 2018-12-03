package module8;

public class CountdownTask implements Runnable {

	int time;

	public CountdownTask(int time) {
		this.time = time;
	}

	public void run() {
		for (int i = time; i > 0; i--) {
			System.out.println("Seceonds left is: " + time);
		}
	}
}
