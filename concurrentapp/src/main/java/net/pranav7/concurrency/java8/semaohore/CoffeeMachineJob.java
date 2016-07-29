package net.pranav7.concurrency.java8.semaohore;

import java.util.concurrent.Semaphore;

import net.pranav7.concurrency.java8.MachineController;

public class CoffeeMachineJob implements Runnable {

	private MachineController controller;
	private Semaphore accessCounter= new Semaphore(5);

	public void setMachineController(final MachineController controller) {
		this.controller = controller;
	}

	@Override
	public void run() {
		try {
			System.out.println(" permits available:: "+accessCounter.availablePermits());
			accessCounter.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller.getAvailableMachine().dispenseCofee();
		accessCounter.release();
	}

}
