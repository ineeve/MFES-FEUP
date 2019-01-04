package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import vdm.Kid2Kid;

public class NewTransactionMenu extends Menu {

	private String cashierName;
	private Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
	private VDMSet clients;
	
	public NewTransactionMenu(String cashierName) {
		this.cashierName = cashierName;
		this.clients = kid2kid.getClients();
	}
	
	@Override
	public void initialize() {
		clients.forEach((client) -> {
			System.out.println(client);
			System.out.println(client.getClass().getName());
		});
	}
}
