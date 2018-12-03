package module8;

import java.util.Collections;

public class ThreadsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread countdown = new Thread(new CountdownTask(3));
		countdown.start();

		Thread prime = new Thread(new PrimeNumberTask());
		prime.start();

		try {
			countdown.join();
			prime.interrupt();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Largest integer checked is: " + PrimeNumberTask.getLargestN());

		System.out.println("The largest prime found is: " + Collections.max(PrimeNumberTask.getPrimeList()));
		System.out.println("The total prime numbers is: " + PrimeNumberTask.getPrimeList().size());

	}

}
