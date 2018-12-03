package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread countdown = new Thread(new CountdownTask(20));
		countdown.start();

		Thread prime = new Thread(new PrimeNumberTask());
		prime.start();

		try {
			countdown.join();
			prime.interrupt();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
