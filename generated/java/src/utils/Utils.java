package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {

	public static vdm.Date getToday() {
		Calendar today = new GregorianCalendar();
		int day = today.get(Calendar.DATE);
		int month = today.get(Calendar.MONTH) + 1;
		int year = today.get(Calendar.YEAR);
		return new vdm.Date(day, month, year);
	}
}
