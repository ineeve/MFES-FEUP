package cli;

import vdm.Client;
import vdm.StoreCashier;

public class PickNewTransactionTypeMenu extends Menu {

	private Client client;
	private StoreCashier cashier;

	public PickNewTransactionTypeMenu(Client client, StoreCashier cashier) {
		this.client = client;
		this.cashier = cashier;
		loop();
	}
	
	@Override
	public void initialize() {
		addOption("Buy", () -> new BuyMenu(client));
		addOption("Sell", () -> new SellMenu(client, cashier));
	}

}
