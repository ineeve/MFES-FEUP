package cli.cashier;

import cli.Menu;
import vdm.Client;

public class PickNewTransactionTypeMenu extends Menu {

	private Client client;

	public PickNewTransactionTypeMenu(Client client) {
		this.client = client;
		loop();
	}
	
	@Override
	protected void initialize() {
		addOption("Buy", () -> new BuyMenu(client));
		addOption("Sell", () -> new SellMenu(client));
	}

}
