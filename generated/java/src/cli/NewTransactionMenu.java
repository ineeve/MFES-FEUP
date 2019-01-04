package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;

public class NewTransactionMenu extends Menu {

	private String cashierName;
	private Kid2Kid kid2kid;
	private VDMSet clients;
	
	public NewTransactionMenu(String cashierName) {
		this.cashierName = cashierName;
	}
	
	@Override
	public void initialize() {
		kid2kid = Kid2KidSingleton.getInstance();
		clients = kid2kid.getClients();
		addOption("New client", () -> new NewClientForTransaction());
		clients.forEach((client) -> {
			addOption(((Client) client).getName(), () -> new PickNewTransactionTypeMenu(client));
		});
	}
}
