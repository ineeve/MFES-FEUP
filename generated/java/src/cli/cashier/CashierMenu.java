package cli.cashier;

import cli.Menu;

public class CashierMenu extends Menu  {
	
	public CashierMenu() {
		loop();
	}

	@Override
	protected void initialize() {
		addOption("New transaction", () -> new NewTransactionMenu());
		addOption("List transactions", () -> new ListTransactionsCashierMenu());
	}

}
