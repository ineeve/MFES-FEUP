package cli;

import instance.Kid2KidSingleton;
import utils.Utils;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.Product;
import vdm.StoreCashier;

public class SelectPaymentForProductSaleMenu extends Menu {

	private Client client;
	private Product product;

	public SelectPaymentForProductSaleMenu(Client client, Product product) {
		this.client = client;
		this.product = product;
	}

	@Override
	public void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		StoreCashier cashier = kid2kid.getLoggedInCashier();
		addOption("Cash", () -> kid2kid.sellProductInCash(product, client, cashier, Utils.getToday()));
		addOption("Credit Notes", () -> kid2kid.sellProductInCreditNotes(product, client, cashier, Utils.getToday()));
		addOption("Gift Cards", () -> System.err.println("PLACEHOLDER")); //kid2kid.sellProductInGiftCards(product, client, cashier, Utils.getToday()));
	}

}
