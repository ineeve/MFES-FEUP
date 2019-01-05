package cli;

public class AdminMenu extends Menu {

	public AdminMenu() {
		loop();
	}
	
	@Override
	protected void initialize() {
		addOption("List clients", () -> new ListClientsAdminMenu());
		addOption("List transactions", () -> new ListTransactionsAdminMenu());
		addOption("List cashiers", () -> new ListCashiersAdminMenu());
	}

}
