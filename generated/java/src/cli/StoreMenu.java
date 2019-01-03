package cli;

public class StoreMenu extends Menu {

	@Override
	public void initialize() {
		addOption("Lisboa", () -> new CashierMenu("Lisboa"));
	}

}
