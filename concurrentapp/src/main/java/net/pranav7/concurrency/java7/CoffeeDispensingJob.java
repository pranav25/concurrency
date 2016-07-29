package net.pranav7.concurrency.java7;

public class CoffeeDispensingJob implements Runnable {

	private CoffeeVendingMachine machine;

	public CoffeeDispensingJob(CoffeeVendingMachine machine) {
		this.machine = machine;
	}

	@Override
	public void run() {
		try {
			System.out.printf("%s: Going to prepare a coffee\n",Thread.currentThread().getName());
			machine.dispenseCoffee();
			System.out.printf("%s: Coffee has been prepared",Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
