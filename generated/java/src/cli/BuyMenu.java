package cli;

import instance.Kid2KidSingleton;
import utils.Utils;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.Product;
import vdm.StoreCashier;

public class BuyMenu extends Menu {
	
	private Client client;
	private Product product;
	
	public BuyMenu(Client client) {
		this.client = client;
		this.product = enterNewProductInfo();
		loop();
	}

	private Product enterNewProductInfo() {
		System.err.println("PLACEHOLDER");
		return new Product();
	}

	@Override
	protected void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		StoreCashier cashier = kid2kid.getLoggedInCashier();
		addOption("Cash", () -> kid2kid.buyProductInCash(product, client, cashier, Utils.getToday()));
		addOption("Credit Notes", () -> kid2kid.buyProductInCreditNotes(product, client, cashier, Utils.getToday()));
	}
}
