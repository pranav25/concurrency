package net.pranav7.concurrency.java7;


public class CofeeMachineMain {

	public static void main(String[] args) {
		CoffeeVendingMachine coffeeJob = new CoffeeVendingMachine();

		// Creates ten Threads
		Thread thread[] = new Thread[12];
		for (int i = 0; i < 12; i++) {
			thread[i] = new Thread(new CoffeeDispensingJob(coffeeJob), "Thread " + i);
		}

		// Starts the Threads
		for (int i = 0; i < 12; i++) {
			thread[i].start();
		}
	}
}
