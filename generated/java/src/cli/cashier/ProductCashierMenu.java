package cli.cashier;

import cli.Menu;
import vdm.Product;

public class ProductCashierMenu extends Menu {

	private Product product;

	public ProductCashierMenu(Product product) {
		this.product = product;
		loop();
	}

	@Override
	protected void initialize() {
		addOption("Show details", () -> System.out.println(product));
		addOption("Set description", () -> setProductDescription());
		addOption("Set sale price", () -> setProductSalePrice());
	}

	private void setProductSalePrice() {
		double newPrice = scanner.nextDouble();
		product.setSellPrice(newPrice);
	}

	private void setProductDescription() {
		String newDescription = scanner.next();
		product.setDescription(newDescription);
	}

}
