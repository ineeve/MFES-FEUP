package cli.cashier;

import org.overture.codegen.runtime.VDMSet;

import cli.Menu;
import instance.Kid2KidSingleton;
import vdm.Kid2Kid;
import vdm.Product;

public class ListProductsCashierMenu extends Menu {

	public ListProductsCashierMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		VDMSet products = kid2kid.getProductsAtStore(kid2kid.getLoggedInCashier().getStore());
		products.forEach(productObj -> {
			Product product = (Product) productObj;
			addOption(product.getDescription(), () -> {
				new ProductCashierMenu(product);
				reinitialize();
			});
		});
	}

}
