package cli;

import java.util.Scanner;

import instance.Kid2KidFactory;
import vdm.Kid2Kid;
import vdm.StoreCashier;
import vdm.quotes.AdminQuote;
import vdm.quotes.CashierQuote;
import vdm.quotes.LoggedOutQuote;

public class Login {

	private Kid2Kid kid2kid = Kid2KidFactory.getKid2Kid();

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
				System.out.println("admin");
				new AdminMenu();
			} else if (loginStatus instanceof CashierQuote) {
				System.out.println("cashier");
				new CashierMenu(username);
			}
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}