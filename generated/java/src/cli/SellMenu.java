package cli;

import vdm.Client;
import vdm.StoreCashier;

public class SellMenu extends Menu {

	private Client client;
	private StoreCashier cashier;

	public SellMenu(Client client, StoreCashier cashier) {
		this.client = client;
		this.cashier = cashier;
		loop();
	}
	
	@Override
	public void initialize() {
		addOption("Sell product", () -> new SelectProductSellMenu(client, cashier));
		addOption("Sell gift card", () -> new SellGiftCardMenu(client, cashier));
	}

}
