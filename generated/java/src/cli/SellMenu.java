package cli;

import vdm.Client;

public class SellMenu extends Menu {

	private Client client;

	public SellMenu(Client client) {
		this.client = client;
	}
	
	@Override
	public void initialize() {
		addOption("Sell product", () -> new SelectProductSellMenu(client));
		addOption("Sell gift card", () -> new SellGiftCardMenu(client));
	}

}
