package net.pranav7.concurrency.java8.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Director {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
	
		
		LightManagementTask lightTask=new LightManagementTask(latch); 
		Thread t1 = new Thread(lightTask);
		SoundManagementTask soundTask=new SoundManagementTask(latch); 
		Thread t2 = new Thread(soundTask);
		
		t1.start();
		t2.start();
		latch.countDown();
		latch.countDown();
		
	}
}


class LightManagementTask implements Runnable {
	CountDownLatch latch;
	public LightManagementTask (final CountDownLatch latch) {
		this.latch=latch;
	}
	@Override 
	public void run () {
		try {
			System.out.println(" Light mgmt latch  count"+latch.getCount());
			latch.await();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Light mgmt latch  count after "+latch.getCount());
		System.out.println( "Light .....");
		try {
		TimeUnit.SECONDS.sleep(4);
		}
		catch(InterruptedException itex) {
			itex.printStackTrace();
		}
	}
}

class SoundManagementTask implements Runnable {
	CountDownLatch latch;
	public SoundManagementTask ( final CountDownLatch latch) {
		this.latch=latch;
	}
	@Override 
	public void run () {
		try {
			System.out.println(" SoundManagementTask  count"+latch.getCount());
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" SoundManagementTask  count After ::"+latch.getCount());
		System.out.println(" SoundManagement .....");
		try {
		TimeUnit.SECONDS.sleep(4);
		}
		catch(InterruptedException itex) {
			itex.printStackTrace();
		}
	}
}