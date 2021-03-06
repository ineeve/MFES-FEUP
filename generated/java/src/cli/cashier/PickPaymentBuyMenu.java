package cli.cashier;

import cli.Menu;
import instance.Kid2KidSingleton;
import utils.ProductFactory;
import utils.Utils;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.Product;
import vdm.StoreCashier;

public class PickPaymentBuyMenu extends Menu {

	private Client client;
	private Product product;

	public PickPaymentBuyMenu(Client client, String productType, String productState) {
		this.client = client;
		this.product = ProductFactory.make(productType, productState);
		loop();
	}

	@Override
	protected void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		StoreCashier cashier = kid2kid.getLoggedInCashier();
		addOption("Cash", () -> kid2kid.buyProductInCash(product, client, cashier, Utils.getToday()));
		addOption("Credit Notes", () -> kid2kid.buyProductInCreditNotes(product, client, cashier, Utils.getToday()));
	}

}
