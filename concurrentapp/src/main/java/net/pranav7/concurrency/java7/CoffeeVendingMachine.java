package net.pranav7.concurrency.java7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoffeeVendingMachine {

	private Lock machineLock;
	private Semaphore semaphore;
	private boolean freeMachines[];

	public CoffeeVendingMachine() {
		freeMachines=new boolean[3];
		semaphore = new Semaphore(5);
		for (int i = 0; i < 3; i++) {
			freeMachines[i] = true;
		}
		machineLock = new ReentrantLock();
	}

	public void dispenseCoffee() throws InterruptedException{
		semaphore.acquire(); 
		try {
			Long duration = (long) (Math.random() * 10000);
			int assignedMachineId=getFreeVendingMachineLocation();
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",Thread.currentThread().getName(),assignedMachineId,duration);
			Thread.sleep(duration);
			freeMachines[assignedMachineId]=true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private int getFreeVendingMachineLocation() {
		int ret=1;
		try {
		machineLock.lock();
		for (int i=0;i<freeMachines.length;i++) {
			if(freeMachines[i]) {
				ret=i;
				freeMachines[i]=false;
				break;
			}
		}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		machineLock.unlock();
		return ret;
	}
}
