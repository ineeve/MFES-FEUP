package instance;

import vdm.Kid2Kid;
import vdm.Store;
import vdm.StoreCashier;

public class Kid2KidFactory {
	
	private static final String[] stores = {"Porto", "Lisboa", "Aveiro"};
	private static final String cashierName = "Alberto";
	
	public static Kid2Kid getKid2Kid() {
		Kid2Kid kid2kid = new Kid2Kid();
		setDefaultValues(kid2kid);
		return kid2kid;
	}
	
	private static void setDefaultValues(Kid2Kid kid2kid) {
		addStores(kid2kid);
	}

	private static void addStores(Kid2Kid kid2kid) {
		for (String storeName : stores) {
			Store store = new Store(storeName);
			store.addCashier(new StoreCashier(cashierName, store));
			kid2kid.addStore(new Store(storeName));
		}
	}
}
