package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;

public class ListClientsAdminMenu extends Menu {

	public ListClientsAdminMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		VDMSet clients = kid2kid.getClients();
		clients.forEach(clientObj -> {
			Client client = (Client) clientObj;
			addOption(client.getName(), () -> new ClientAdminMenu(client));
		});
	}

}
