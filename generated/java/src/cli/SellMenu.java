package cli;

import vdm.Client;
import vdm.StoreCashier;

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
