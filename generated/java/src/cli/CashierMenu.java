package cli;

public class CashierMenu extends Menu  {

	// private Cashier[] cashiers;
	private String location;
	
	public CashierMenu(String location) {
		this.location = location;
	}

	@Override
	public void initialize() {
		addOption("New transaction", () -> new NewTransactionMenu(location));
	}

}
