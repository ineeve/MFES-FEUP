package cli.admin;

import org.overture.codegen.runtime.VDMSet;

import cli.Menu;
import instance.Kid2KidSingleton;
import vdm.Store;

public class ListStoresAdminMenu extends Menu {

	public ListStoresAdminMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		VDMSet stores = Kid2KidSingleton.getInstance().getStores();
		addOption("New store", () -> {
			newStore();
			reinitialize();
		});
		stores.forEach(storeObj -> {
			Store store = (Store) storeObj;
			addOption(store.getLocation(), () -> {
				new StoreAdminMenu(store);
				reinitialize();
			});
		});
	}

	private void newStore() {
		System.out.print("Location: ");
		String location = scanner.next();
		Kid2KidSingleton.getInstance().addStore(new Store(location));
	}

}
