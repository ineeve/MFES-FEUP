package cli;

import vdm.Client;

public class PickNewTransactionTypeMenu extends Menu {

	private Client client;

	public PickNewTransactionTypeMenu(Client client) {
		this.client = client;
		loop();
	}
	
	@Override
	public void initialize() {
		addOption("Buy", () -> new BuyMenu(client));
		addOption("Sell", () -> new SellMenu(client));
	}

}
