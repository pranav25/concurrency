package net.pranav7.concurrency.java8;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoffeeMachine {
	private MachineStatus status;
	private int machineId;
	Lock reentrantLock=new ReentrantLock();
	public CoffeeMachine(int id,MachineStatus status) {
		this.machineId=id;
		this.status=status;
	}

	public int getMachineId() {
		return machineId;
	}


	public void dispenseCofee() {
		 reentrantLock.lock();
		this.setStatus(MachineStatus.INUSE);
		
		try {
		TimeUnit.SECONDS.sleep(5);
		//System.out.println(" Coffee machine Id :"+this.getMachineId() +" dispensing coffee ");
		}
		catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		this.setStatus(MachineStatus.AVAILABLE);
		System.out.println(" Coffee machine Id :"+this.getMachineId() +":usage Complete ");
		reentrantLock.unlock();
	}

	public MachineStatus getStatus() {
		return status;
	}

	public void setStatus(MachineStatus status) {
		this.status = status;
	}

}
/*
class MachineStatusTracker 
{
	private  List<CoffeeMachine> machinesList;

	public MachineStatusTracker(List<CoffeeMachine> machinesList) {
		super();
		this.machinesList = machinesList;
	}
	
	public CoffeeMachine getAvailableMachine() {
		CoffeeMachine coffeeMachine = null;
		Optional<CoffeeMachine> machine = machinesList.stream()
				.filter(p -> p.getStatus().equals(MachineStatus.AVAILABLE)).findAny();
		if (machine.isPresent())
			coffeeMachine = machine.get();
		System.out.println(" Available machine returned "+coffeeMachine.getMachineId());
		return coffeeMachine;
	}
	
} 
*/