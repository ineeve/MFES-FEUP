package cli.cashier;

import cli.Menu;
import vdm.Client;

public class PickProductStateBuyMenu extends Menu {
	
	private Client client;
	private String productType;

	public PickProductStateBuyMenu(Client client, String productType) {
		this.client = client;
		this.productType = productType;
		loop();
	}

	@Override
	protected void initialize() {
		addOption("New", () -> new PickPaymentBuyMenu(client, productType, "New"));
		addOption("Low use", () -> new PickPaymentBuyMenu(client, productType, "Low_Use"));
		addOption("High use", () -> new PickPaymentBuyMenu(client, productType, "High_Use"));
	}

}
