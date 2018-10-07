package module1;

public class AlgortihmControl {

	// loop method for printing integers from 1 to 8
	public static void loop() {
		for(int i = 1; i <= 8; i++) {
			System.out.println(i);
			
		}
	}

	// loop method for printing integers from 10 to -5
	public static void decrement() {

		for(int i = 10; i >= -5; i--) {
			System.out.println(i);
			
		}

	}

	//loop method for printing 2.5 to 4.3 in 0.1 increments
	public static void increment() {
		for(double i = 25 ; i <= 43; i++) {
			System.out.println(i/10);
			
		}
	}

	// loop method for running a chosen time interval and printing every chosen
	// interval of loops the number of loops passed
	public static int timer(double maxTime, int loopSteps) {
		// timer method
		// initialise variables
		long timeNow = System.currentTimeMillis();
		int loops = 0;
		float timeDif = 0;
		// while loop to loop until maxTime time has passed
		while(timeDif < (maxTime*1000)) {
			timeDif = System.currentTimeMillis() - timeNow;
			loops++;
			if(loops % loopSteps == 0) { // if statement to print the number of loops every set loopSteps
				System.out.println("The number of Timer loops run so far is " + loops);
			}	
		}
		return loops; // method returns total number of loops done
	}

	// main method
	public static void main(String[] args) {
		//// Calling methods from above
		System.out.println("Result of loop method is");
		loop();
		System.out.println("Result of decrement method is:");
		decrement();
		System.out.println("Result of increment method is:");
		increment();
		System.out.println("Result of timer method is:");
		int loopsTotal = timer(5,100);
		System.out.println("Total loops run is " + loopsTotal);
		int loopsTotal2 = timer(10,50000);
		System.out.println("Total loops run is " + loopsTotal2);
		System.out.println("Why result?"); //small explanation
		
	}

}
