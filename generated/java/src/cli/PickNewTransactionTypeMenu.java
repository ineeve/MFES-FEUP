package cli;

public class PickNewTransactionTypeMenu extends Menu {

	@Override
	public void initialize() {
		addOption("Buy", () -> new BuyMenu());
		addOption("Sell", () -> new SellMenu());
	}

}
