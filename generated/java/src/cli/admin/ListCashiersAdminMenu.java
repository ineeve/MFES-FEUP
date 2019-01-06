package cli.admin;

import org.overture.codegen.runtime.VDMSet;

import cli.Menu;
import vdm.Store;
import vdm.StoreCashier;

public class ListCashiersAdminMenu extends Menu {

	private Store store;

	public ListCashiersAdminMenu(Store store) {
		this.store = store;
		addCashierOptions();
		loop();
	}
	
	// Needed so it runs after the constructor sets the store.
	@SuppressWarnings("unchecked")
	private void addCashierOptions() {
		addOption("New cashier", () -> {
			addCashier();
			reinitialize();
			addCashierOptions();
		});
		VDMSet cashiers = store.getCashiers();
		cashiers.forEach(cashierObj -> {
			StoreCashier cashier = (StoreCashier) cashierObj;
			addOption(cashier.getName(), () -> {
				new CashierAdminMenu(cashier);
				reinitialize();
				addCashierOptions();
			});
		});
	}

	private void addCashier() {
		System.out.print("Cashier name: ");
		String name = scanner.next();
		store.addCashier(new StoreCashier(name, store));
	}

	@Override
	protected void initialize() {}

}
