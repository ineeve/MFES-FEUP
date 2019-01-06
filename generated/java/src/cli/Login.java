package cli;

import java.util.Scanner;

import cli.admin.AdminMenu;
import cli.cashier.CashierMenu;
import instance.Kid2KidSingleton;
import vdm.Kid2Kid;
import vdm.quotes.AdminQuote;
import vdm.quotes.CashierQuote;
import vdm.quotes.LoggedOutQuote;

public class Login {

	private Kid2Kid kid2kid = Kid2KidSingleton.getInstance();

	public Login() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String username;
			Object loginStatus;
			do {
				System.out.print("Username ['Admin'/Store_CashierName]: ");
				username = scanner.next();
				loginStatus = login(username);
			} while (loginStatus instanceof LoggedOutQuote);
			if (loginStatus instanceof AdminQuote) {
				new AdminMenu();
			} else if (loginStatus instanceof CashierQuote) {
				new CashierMenu();
			}
		}
	}
	
	private Object login(String username) {
		Object adminAttempt = kid2kid.login(username);
		if (adminAttempt instanceof AdminQuote) {
			return adminAttempt;
		}
		// Admin login failed, try cashier login
		if (!username.contains("_")) { // invalid login
			return new LoggedOutQuote();
		}
		String[] parts = username.split("_");
		String store = parts[0];
		String cashier = parts[1];
		return kid2kid.login(store, cashier);
	}

	public static void main(String[] args) {
		new Login();
	}
}
