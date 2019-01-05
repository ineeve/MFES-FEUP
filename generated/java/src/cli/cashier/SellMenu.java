package cli.cashier;

import cli.Menu;
import vdm.Client;

public class SellMenu extends Menu {

	private Client client;

	public SellMenu(Client client) {
		this.client = client;
		loop();
	}
	
	@Override
	protected void initialize() {
		addOption("Sell product", () -> new SelectProductSellMenu(client));
		addOption("Sell gift card", () -> new SellGiftCardMenu(client));
	}

}
