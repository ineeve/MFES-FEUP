package cli;

public class CashierMenu extends Menu  {

	// private Cashier[] cashiers;
	
	@Override
	public void initialize() {
		// get vdm cashiers
		// loop cashiers
		addOption("Margarida", () -> System.out.println("Picked cashier 1"));
		addOption("Renato", () -> System.out.println("Picked cashier 2"));
	}

}
