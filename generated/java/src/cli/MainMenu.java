package cli;

public class MainMenu extends Menu {
	
//	public MainMenu() {
//		initialize();
//	}

	@Override
	public void initialize() {
		addOption("Cashiers", () -> new CashierMenu());
	}
	
	public static void main(String[] args) {
		new MainMenu();
	}

}
