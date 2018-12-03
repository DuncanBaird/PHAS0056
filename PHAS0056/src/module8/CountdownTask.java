package module8;

public class CountdownTask implements Runnable {

	int time;

	public CountdownTask(int time) {
		this.time = time;
	}

	public void run() {
		try {
		for (int i = this.time; i > -1; i--) {
				Thread.sleep(1000);
			System.out.println("Seconds left is: " + i);
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
