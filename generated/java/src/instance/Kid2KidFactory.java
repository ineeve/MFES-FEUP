package instance;

import vdm.Kid2Kid;
import vdm.Store;

public class Kid2KidFactory {
	
	private static final String[] stores = {"Porto", "Lisboa", "Aveiro"};
	
	public static Kid2Kid getKid2Kid() {
		Kid2Kid kid2kid = new Kid2Kid();
		setDefaultValues(kid2kid);
		return kid2kid;
	}
	
	private static void setDefaultValues(Kid2Kid kid2kid) {
		addStores(kid2kid);
	}

	private static void addStores(Kid2Kid kid2kid) {
		for (String store : stores) {
			kid2kid.addStore(new Store(store));
		}
	}
}
