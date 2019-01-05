package cli.admin;

import org.overture.codegen.runtime.VDMSet;

import cli.Menu;
import instance.Kid2KidSingleton;
import vdm.Kid2Kid;
import vdm.StoreCashier;

public class ListCashiersAdminMenu extends Menu {

	public ListCashiersAdminMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		VDMSet cashiers = kid2kid.getCashiers();
		cashiers.forEach(cashierObj -> {
			StoreCashier cashier = (StoreCashier) cashierObj;
			addOption(cashier.getName(), () -> {
				new CashierAdminMenu(cashier);
				reinitialize();
			});
		});
	}

}
