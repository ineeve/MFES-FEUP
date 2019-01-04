package cli;

import instance.Kid2KidFactory;
import vdm.Kid2Kid;
import vdm.StoreCashier;

public class LoginMenu extends Menu {

	private Kid2Kid kid2kid = Kid2KidFactory.getKid2Kid();
	
	@Override
	public void initialize() {
		addOption("Login as Cashier", () -> loginCashier());
		addOption("Login as Admin", () -> loginAdmin());
	}

	public static void main(String[] args) {
		new LoginMenu();
	}
	
	private void loginCashier() {
		String username = scanner.next();
		StoreCashier cashier = kid2kid.getCashier();
		new CashierMenu(cashier);
	}

}
