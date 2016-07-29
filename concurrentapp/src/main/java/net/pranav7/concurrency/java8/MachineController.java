package net.pranav7.concurrency.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MachineController {
	//private CoffeeMachine machine;
	private List<CoffeeMachine> machinesList;

	public void initializeMachines() {
		machinesList = new ArrayList<>();
		machinesList.add(new CoffeeMachine(1, MachineStatus.AVAILABLE));
		machinesList.add(new CoffeeMachine(2, MachineStatus.AVAILABLE));
		machinesList.add(new CoffeeMachine(3, MachineStatus.AVAILABLE));
		machinesList.add(new CoffeeMachine(4, MachineStatus.AVAILABLE));
		machinesList.add(new CoffeeMachine(5, MachineStatus.AVAILABLE));
	}
	
	public List<CoffeeMachine> getMachines() {
		return machinesList;
	}
	
	public void setetMachines(List<CoffeeMachine> m) {
		this.machinesList=m;
	}

	public CoffeeMachine getAvailableMachine() {
		CoffeeMachine coffeeMachine = null;
		Optional<CoffeeMachine> machine =  getMachines().stream()
				.filter(p -> p.getStatus().equals(MachineStatus.AVAILABLE)).findAny();
		if (machine.isPresent())
			coffeeMachine = machine.get();
		System.out.println(" Available machine returned "+coffeeMachine.getMachineId());
		return coffeeMachine;
	}

}
