package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;
import vdm.StoreCashier;

public class NewTransactionMenu extends Menu {

	private StoreCashier cashier;
	private Kid2Kid kid2kid;
	private VDMSet clients;
	
	public NewTransactionMenu(StoreCashier cashier) {
		this.cashier = cashier;
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize() {
		kid2kid = Kid2KidSingleton.getInstance();
		clients = kid2kid.getClients();
		addOption("New client", () -> new NewClientForTransaction(cashier));
		clients.forEach((clientObj) -> {
			Client client = (Client) clientObj;
			addOption(client.getName(), () -> new PickNewTransactionTypeMenu(client, cashier));
		});
	}
}
