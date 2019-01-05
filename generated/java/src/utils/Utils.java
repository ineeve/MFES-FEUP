package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

import vdm.Purchase;
import vdm.Sale;
import vdm.Transaction;

public class Utils {

	public static vdm.Date getToday() {
		Calendar today = new GregorianCalendar();
		int day = today.get(Calendar.DATE);
		int month = today.get(Calendar.MONTH) + 1;
		int year = today.get(Calendar.YEAR);
		return new vdm.Date(day, month, year);
	}

	public static String prettifyTransaction(Transaction transaction) {
		switch (transaction.getClass().getName()) {
		case "vdm.Sale":
			return prettifySale((Sale) transaction);
		case "vdm.Purchase":
			return prettifyPurchase((Purchase) transaction);
		default:
			System.err.println("Invalid Transaction type");
			return "";
		}
	}

	private static String prettifyPurchase(Purchase purchase) {
		return "Purchase | Value: " + purchase.getValue();
	}

	private static String prettifySale(Sale sale) {
		return "Sale | Value: " + sale.getValue();
	}
}
