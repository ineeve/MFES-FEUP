package cli.admin;

import org.overture.codegen.runtime.VDMSet;

import cli.Menu;
import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;

public class ListClientsAdminMenu extends Menu {

	public ListClientsAdminMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		addOption("New client", () -> {
			addNewClient();
			reinitialize();
		});
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		VDMSet clients = kid2kid.getClients();
		clients.forEach(clientObj -> {
			Client client = (Client) clientObj;
			addOption(client.getName(), () -> {
				new ClientAdminMenu(client);
				reinitialize(); // reflect possible changes to this client
			});
		});
	}

	private void addNewClient() {
		System.out.print("Client name: ");
		String name = scanner.next();
		Kid2KidSingleton.getInstance().addClient(new Client(name));
	}

}
