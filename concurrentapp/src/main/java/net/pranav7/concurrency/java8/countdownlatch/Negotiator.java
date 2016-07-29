package net.pranav7.concurrency.java8.countdownlatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Negotiator {

	public static void main(String[] args) {
		Negotiation nego = new Negotiation();
		CyclicBarrier barrier = new CyclicBarrier(3,nego);
		Negotaitor1 nego1 = new Negotaitor1(barrier);
		Negotaitor2 nego2 = new Negotaitor2(barrier);
		Thread t1 = new Thread(nego1);
		Thread t2 = new Thread(nego2);
		t1.start();
		t2.start();

	}
}

class Negotiation implements Runnable {
	

	@Override
	public void run() {
		System.out.println(" -----Final Task-------  ");
	}
}

class Negotaitor1 implements Runnable {
	CyclicBarrier barrier;

	public Negotaitor1(final CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException itex) {
			itex.printStackTrace();
		}
		try {
			System.out.println(" Task completed for Negotiator 1 Waiting Count:: " + barrier.getNumberWaiting());
			System.out.println("Total parties  " + barrier.getParties());
			barrier.await();
			System.out.println("After await inside Nego1  " + barrier.getNumberWaiting());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting Negotiator 1  thread .");
		
	}
}

class Negotaitor2 implements Runnable {
	CyclicBarrier barrier;

	public Negotaitor2(final CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException itex) {
			itex.printStackTrace();
		}
		
		try {
			System.out.println(" Task completed for Negotiator 2 : waiting count:: " + barrier.getNumberWaiting());
			System.out.println("Total parties  " + barrier.getParties());
			barrier.await();
			System.out.println("After await inside Nego2  " + barrier.getNumberWaiting());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting Negotiator 2  thread .");
		
		
	}
}
