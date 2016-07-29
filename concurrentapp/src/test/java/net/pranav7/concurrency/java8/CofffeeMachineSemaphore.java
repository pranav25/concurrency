package net.pranav7.concurrency.java8;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CofffeeMachineSemaphore {
	private static List<CoffeeMachine> list = new ArrayList<>();
	@Before 
	public void setUp() {
		list.add(new CoffeeMachine(1, MachineStatus.AVAILABLE));
		list.add(new CoffeeMachine(2, MachineStatus.AVAILABLE));
		list.add(new CoffeeMachine(3, MachineStatus.AVAILABLE));
		list.add(new CoffeeMachine(4, MachineStatus.AVAILABLE));
		list.add(new CoffeeMachine(5, MachineStatus.AVAILABLE));
		
	}
	@Test
	public void givenAllMachinesCheckIfAvailable() {
		Assert.assertTrue(list.stream().
				filter(p->p.getStatus().equals(MachineStatus.INUSE))
				.count()<1);
	}

}
