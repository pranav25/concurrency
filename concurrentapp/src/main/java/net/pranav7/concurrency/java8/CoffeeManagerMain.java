package net.pranav7.concurrency.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import net.pranav7.concurrency.java8.semaohore.CoffeeMachineJob;

public class CoffeeManagerMain {
	static MachineController controller;
	static CoffeeMachineJob job;

	public static void main(String[] args) throws InterruptedException {
		controller = new MachineController();
		job = new CoffeeMachineJob();
		controller.initializeMachines();
		ExecutorService pool = Executors.newFixedThreadPool(10);
		job.setMachineController(controller);
		IntStream.range(0, 10).forEach(i -> pool.submit(job));
		pool.shutdown();

	}

}
