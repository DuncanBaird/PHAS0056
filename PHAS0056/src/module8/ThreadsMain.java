package module8;

import java.util.Collections;

public class ThreadsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread countdown = new Thread(new CountdownTask(5));
		countdown.start();

		Thread prime = new Thread(new PrimeNumberTask());
		prime.start();

		try {
			countdown.join();
			prime.interrupt();
			System.out.println("LArgest integer checked is: " + PrimeNumberTask.getLargestN());
			System.out.println("The largest prime found is: " + Collections.max(PrimeNumberTask.getPrimeList()));
			System.out.println("The total prime numbers is: " + PrimeNumberTask.getPrimeList().size());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
