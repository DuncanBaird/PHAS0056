package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread countdown = new Thread(new CountdownTask(20));
		countdown.start();
	}

}
