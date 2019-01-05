package cli;

public class AdminMenu extends Menu {

	public AdminMenu() {
		loop();
	}
	
	@Override
	public void initialize() {
		addOption("List clients", () -> new ListClientsAdminMenu());
		addOption("List transactions", () -> new ListTransactionsAdminMenu());
	}

}
