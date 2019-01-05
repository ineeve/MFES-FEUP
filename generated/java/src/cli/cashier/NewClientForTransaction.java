package cli.cashier;

import java.util.Scanner;

import vdm.Client;

public class NewClientForTransaction {
	
	public NewClientForTransaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Name: ");
		String name = scanner.next();
		Client client = new Client(name);
		new PickNewTransactionTypeMenu(client);
	}
	
}
