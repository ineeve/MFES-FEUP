package cli;

import instance.Kid2KidSingleton;
import vdm.StoreCashier;

public class CashierAdminMenu extends Menu {

	private StoreCashier cashier;

	public CashierAdminMenu(StoreCashier cashier) {
		this.cashier = cashier;
		loop();
	}
	
	@Override
	protected void initialize() {
		addOption("Rename", () -> renameCashier());
		addOption("Remove", () -> removeClient());
	}

	private void renameCashier() {
		System.out.print("New name for " + cashier.getName() + ": ");
		String name = scanner.next();
		cashier.setName(name);
	}

	private void removeClient() {
		Kid2KidSingleton.getInstance().removeCashier(cashier);
	}

}
