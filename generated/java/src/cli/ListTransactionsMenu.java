package cli;

import instance.Kid2KidSingleton;

public class ListTransactionsMenu extends Menu {

	@Override
	public void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
	}

}
