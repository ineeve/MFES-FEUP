package cli;

public class MainMenu extends Menu {
	
//	public MainMenu() {
//		initialize();
//	}

	@Override
	public void initialize() {
		addOption("Stores", () -> new StoreMenu());
		addOption("Transactions", () -> new TransactionMenu());
		addOption("Clients", () -> new ClientMenu());
	}
	
	public static void main(String[] args) {
		new MainMenu();
	}

}
