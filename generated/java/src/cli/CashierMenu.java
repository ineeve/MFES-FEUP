package cli;

import vdm.StoreCashier;

public class CashierMenu extends Menu  {
	
	public CashierMenu() {
		loop();
	}

	@Override
	public void initialize() {
		addOption("New transaction", () -> new NewTransactionMenu());
		addOption("List transactions", () -> new ListTransactionsCashierMenu());
	}

}
