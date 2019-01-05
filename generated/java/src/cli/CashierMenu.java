package cli;

import vdm.StoreCashier;

public class CashierMenu extends Menu  {

	private StoreCashier cashier;
	
	public CashierMenu(StoreCashier cashier) {
		this.cashier = cashier;
		loop();
	}

	@Override
	public void initialize() {
		addOption("New transaction", () -> new NewTransactionMenu(cashier));
	}

}
