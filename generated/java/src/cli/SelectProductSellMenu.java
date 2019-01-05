package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.Product;
import vdm.StoreCashier;

public class SelectProductSellMenu extends Menu {

	private Client client;

	public SelectProductSellMenu(Client client) {
		this.client = client;
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		StoreCashier cashier = kid2kid.getLoggedInCashier();
		VDMSet products = kid2kid.getProductsAtStore(cashier.getStore());
		products.forEach((productObj) -> {
			Product product = (Product) productObj;
			addOption(product.getDescription(), () -> new SelectPaymentForProductSaleMenu(client, product));
		});
	}

}
