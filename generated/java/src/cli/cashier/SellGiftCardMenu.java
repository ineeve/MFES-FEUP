package cli.cashier;

import cli.Menu;
import instance.Kid2KidSingleton;
import utils.Utils;
import vdm.Client;
import vdm.GiftCard;
import vdm.Kid2Kid;
import vdm.StoreCashier;

public class SellGiftCardMenu extends Menu {

	private Client client;

	public SellGiftCardMenu(Client client) {
		this.client = client;
		loop();
	}

	@Override
	protected void initialize() {
		for (Object valueObj : GiftCard.getPossibleValues()) {
			Long value = (Long) valueObj;
			addOption(value.toString(), () -> sell(value));
		}
	}

	private void sell(Long value) {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		StoreCashier cashier = kid2kid.getLoggedInCashier();
		kid2kid.sellGiftCard(client, cashier, Utils.getToday(), value);
	}

}
