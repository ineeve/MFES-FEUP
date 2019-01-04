package instance;

import vdm.Kid2Kid;

public class Kid2KidSingleton {
	private static Kid2Kid instance;
	
	public static Kid2Kid getInstance() {
		if (instance == null) {
			instance = Kid2KidFactory.getKid2Kid();
		}
		return instance;
	}
}
