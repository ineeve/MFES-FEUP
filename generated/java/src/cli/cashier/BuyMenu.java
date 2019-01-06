package cli.cashier;

import cli.Menu;
import instance.Kid2KidSingleton;
import utils.Utils;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.StoreCashier;

public class BuyMenu extends Menu {

	private static final String[] productTypes = {"Clothing", "Footwear", "Furniture", "Gear", "Toy"};
	private Client client;
	
	public BuyMenu(Client client) {
		this.client = client;
		loop();
	}

	@Override
	protected void initialize() {		
		for (String productType : productTypes) {
			addOption(productType, () -> new PickProductStateBuyMenu(client, productType));
		}
	}
}
