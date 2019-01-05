package cli.cashier;

import org.overture.codegen.runtime.VDMSet;

import cli.Menu;
import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;

public class NewTransactionMenu extends Menu {

	private Kid2Kid kid2kid;
	private VDMSet clients;
	
	public NewTransactionMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		kid2kid = Kid2KidSingleton.getInstance();
		clients = kid2kid.getClients();
		addOption("New client", () -> new NewClientForTransaction());
		clients.forEach((clientObj) -> {
			Client client = (Client) clientObj;
			addOption(client.getName(), () -> new PickNewTransactionTypeMenu(client));
		});
	}
}
