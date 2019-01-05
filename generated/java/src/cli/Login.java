package cli;

import java.util.Scanner;

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
				System.out.print("Username: ");
				username = scanner.next();
				loginStatus = kid2kid.login(username);
			} while (loginStatus instanceof LoggedOutQuote);
			if (loginStatus instanceof AdminQuote) {
				new AdminMenu();
			} else if (loginStatus instanceof CashierQuote) {
				new CashierMenu();
			}
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
