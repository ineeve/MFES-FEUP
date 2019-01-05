package cli;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import instance.Kid2KidSingleton;
import vdm.Client;
import vdm.GiftCard;
import vdm.Kid2Kid;
import vdm.StoreCashier;

public class SellGiftCardMenu extends Menu {

	private Client client;
	private StoreCashier cashier;

	public SellGiftCardMenu(Client client, StoreCashier cashier) {
		this.client = client;
		this.cashier = cashier;
		loop();
	}

	@Override
	public void initialize() {
		for (Object valueObj : GiftCard.getPossibleValues()) {
			Long value = (Long) valueObj;
			addOption(value.toString(), () -> sell(value));
		}
	}

	private void sell(Long value) {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		vdm.Date date = getToday();
		kid2kid.sellGiftCard(client, cashier, date, value);
	}

	private vdm.Date getToday() {
		Calendar today = new GregorianCalendar();
		int day = today.get(Calendar.DATE);
		int month = today.get(Calendar.MONTH) + 1;
		int year = today.get(Calendar.YEAR);
		return new vdm.Date(day, month, year);
	}

}
