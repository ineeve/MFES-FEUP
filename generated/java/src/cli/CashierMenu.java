package cli;

public class CashierMenu extends Menu  {

	// private Cashier[] cashiers;
	private String cashierName;
	
	public CashierMenu(String cashierName) {
		this.cashierName = cashierName;
	}

	@Override
	public void initialize() {
		addOption("New transaction", () -> new NewTransactionMenu(cashierName));
		// addOption("List transactions", () -> new ListTransactionsMenu(cashierName));
	}

}
