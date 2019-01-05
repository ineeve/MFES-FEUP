package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.Product;
import vdm.StoreCashier;

public class SelectProductSellMenu extends Menu {

	private Client client;
	private StoreCashier cashier;

	public SelectProductSellMenu(Client client, StoreCashier cashier) {
		this.client = client;
		this.cashier = cashier;
	}

	@Override
	public void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		VDMSet products = kid2kid.getProductsAtStore(cashier.getStore());
		products.forEach((productObj) -> {
			Product product = (Product) productObj;
			addOption(product)
		});
	}

}
