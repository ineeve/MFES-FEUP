package cli.admin;

import cli.Menu;
import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.Kid2Kid;

public class ClientAdminMenu extends Menu {

	private Client client;

	public ClientAdminMenu(Client client) {
		this.client = client;
		loop();
	}

	@Override
	protected void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		addOption("Show details", () -> System.out.println(client));
		addOption("Rename", () -> renameClient());
		addOption("Remove", () -> kid2kid.removeClient(client));
	}

	private void renameClient() {
		System.out.print("New name for " + client.getName() + ": ");
		String name = scanner.next();
		client.setName(name);
	}

}
