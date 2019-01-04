package cli;

import instance.Kid2KidFactory;
import vdm.Kid2Kid;

public class MainMenu extends Menu {
	
	private Kid2Kid kid2kid = Kid2KidFactory.getKid2Kid();

	@Override
	public void initialize() {
		addOption("Stores", () -> new StoreMenu(kid2kid));
		addOption("Transactions", () -> new TransactionMenu());
		addOption("Clients", () -> new ClientMenu());
	}
	
	public static void main(String[] args) {
		new MainMenu();
	}

}
