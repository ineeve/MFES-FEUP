package cli;

import instance.Kid2KidSingleton;
import vdm.Kid2Kid;

public class NewTransactionMenu extends Menu {

	private String cashierName;
	private Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
	
	public NewTransactionMenu(String cashierName) {
		this.cashierName = cashierName;
	}
	
	@Override
	public void initialize() {
		
	}
}
