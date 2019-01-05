package cli;

import vdm.Kid2Kid;

public class StoreMenu extends Menu {
	
	private Kid2Kid kid2kid;

	public StoreMenu(Kid2Kid kid2kid) {
		this.kid2kid = kid2kid;
	}
	
	@Override
	protected void initialize() {
		// addOption("Lisboa", () -> new CashierMenu("Lisboa"));
	}

}
