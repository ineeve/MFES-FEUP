package cli;

import org.overture.codegen.runtime.VDMSet;

import instance.Kid2KidSingleton;
import utils.Utils;
import vdm.Kid2Kid;
import vdm.Transaction;

public class ListTransactionsCashierMenu extends Menu {

	public ListTransactionsCashierMenu() {
		loop();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		Kid2Kid kid2kid = Kid2KidSingleton.getInstance();
		VDMSet transactions = kid2kid.getTransactionsOfLoggedInCashier();
		transactions.forEach(transactionObj -> {
			Transaction transaction = (Transaction) transactionObj;
			addOption(Utils.prettifyTransaction(transaction), () -> System.out.println(transaction));
		});
	}

}
