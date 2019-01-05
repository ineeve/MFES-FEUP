package cli;

import instance.Kid2KidSingleton;
import utils.Utils;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.Product;
import vdm.StoreCashier;

public class SelectPaymentForProductSaleMenu extends Menu {

	private Client client;
	private StoreCashier cashier;
	private Product product;

	public SelectPaymentForProductSaleMenu(Client client, StoreCashier cashier, Product product) {
		this.client = client;
		this.cashier = cashier;
		this.product = product;
	}

	@Override
	public void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		addOption("Cash", () -> kid2kid.sellProductInCash(product, client, cashier, Utils.getToday()));
		addOption("Credit Notes", () -> kid2kid.sellProductInCreditNotes(product, client, cashier, Utils.getToday()));
		// addOption("Gift Cards", () -> kid2kid.sellProductInGiftCards(product, client, cashier, Utils.getToday()));
	}

}
