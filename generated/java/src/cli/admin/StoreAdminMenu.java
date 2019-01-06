package cli.admin;

import cli.Menu;
import vdm.Store;

public class StoreAdminMenu extends Menu {

	private Store store;

	public StoreAdminMenu(Store store) {
		this.store = store;
		loop();
	}
	
	@Override
	protected void initialize() {
		addOption("Show statistics", () -> showStatistics());
		addOption("Set location", () -> {
			setLocation();
			reinitialize();
		});
		addOption("Cashiers", () -> new ListCashiersAdminMenu(store));
	}

	private void setLocation() {
		System.out.print("Location: ");
		String l = scanner.next();
		store.setLocation(l);
	}

	private void showStatistics() {
		System.out.println("Inventory value: " + store.getInventoryValue());
		System.out.println("Revenue: " + store.getRevenue());
	}

}
