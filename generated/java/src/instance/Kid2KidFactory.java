package instance;

import vdm.Client;
import vdm.Kid2Kid;
import vdm.Store;
import vdm.StoreCashier;

public class Kid2KidFactory {
	
	private static final String[] stores = {"Porto", "Lisboa", "Aveiro"};
	private static final String cashierName = "Alberto";
	private static final String[] clients = {"Renato", "Maggie", "Vitor"};
	
	public static Kid2Kid getKid2Kid() {
		Kid2Kid kid2kid = new Kid2Kid();
		setDefaultValues(kid2kid);
		return kid2kid;
	}
	
	private static void setDefaultValues(Kid2Kid kid2kid) {
		addStores(kid2kid);
		addClients(kid2kid);
	}

	private static void addStores(Kid2Kid kid2kid) {
		for (String storeName : stores) {
			Store store = new Store(storeName);
			store.addCashier(new StoreCashier(cashierName, store));
			kid2kid.addStore(store);
		}
	}

	private static void addClients(Kid2Kid kid2kid) {
		for (String clientName : clients) {
			Client client = new Client(clientName);
			kid2kid.addClient(client);
		}
	}
}
