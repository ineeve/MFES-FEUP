package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Kid2Kid {
  private VDMSet clients = SetUtil.set();
  private VDMSet stores = SetUtil.set();
  private VDMSet activeGiftCards = SetUtil.set();
  private VDMSet transactions = SetUtil.set();
  private Object loggedInType = vdm.quotes.LoggedOutQuote.getInstance();
  private String loggedInUsername;

  public void cg_init_Kid2Kid_1() {

    return;
  }

  public Kid2Kid() {

    cg_init_Kid2Kid_1();
  }

  public Object login(final String name) {

    if (Utils.equals(name, "Admin")) {
      loggedInType = vdm.quotes.AdminQuote.getInstance();
      loggedInUsername = "Admin";

    } else {
      if (SetUtil.inSet(name, getCashierNames())) {
        loggedInType = vdm.quotes.CashierQuote.getInstance();
        loggedInUsername = name;
      }
    }

    return loggedInType;
  }

  public StoreCashier getLoggedInCashier() {

    StoreCashier cashier = null;
    for (Iterator iterator_3 = getCashiersInternal().iterator(); iterator_3.hasNext(); ) {
      StoreCashier c = (StoreCashier) iterator_3.next();
      if (Utils.equals(loggedInUsername, c.getName())) {
        cashier = c;
      }
    }
    return cashier;
  }

  public void removeCashier(final StoreCashier c) {

    c.getStore().removeCashier(c);
  }

  public VDMSet getTransactions() {

    return Utils.copy(transactions);
  }

  public VDMSet getTransactionsOfLoggedInCashier() {

    return getTransactionsOfCashier(getLoggedInCashier());
  }

  private VDMSet getTransactionsOfCashier(final StoreCashier cashier) {

    VDMSet setCompResult_1 = SetUtil.set();
    VDMSet set_1 = Utils.copy(transactions);
    for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext(); ) {
      Transaction x = ((Transaction) iterator_1.next());
      if (Utils.equals(x.getCashier(), cashier)) {
        setCompResult_1.add(x);
      }
    }
    return Utils.copy(setCompResult_1);
  }

  private VDMSet getCashierNamesInternal() {

    VDMSet names = SetUtil.set();
    for (Iterator iterator_4 = getCashiersInternal().iterator(); iterator_4.hasNext(); ) {
      StoreCashier cashier = (StoreCashier) iterator_4.next();
      names = SetUtil.union(Utils.copy(names), SetUtil.set(cashier.getName()));
    }
    return Utils.copy(names);
  }

  private VDMSet getCashiersInternal() {

    VDMSet cashiers = SetUtil.set();
    for (Iterator iterator_5 = stores.iterator(); iterator_5.hasNext(); ) {
      Store store = (Store) iterator_5.next();
      cashiers = SetUtil.union(Utils.copy(cashiers), store.getCashiers());
    }
    return Utils.copy(cashiers);
  }

  public VDMSet getCashiers() {

    return getCashiersInternal();
  }

  public VDMSet getCashierNames() {

    return getCashierNamesInternal();
  }

  public void addClient(final Client c) {

    clients = SetUtil.union(Utils.copy(clients), SetUtil.set(c));
  }

  public void removeClient(final Client c) {

    clients = SetUtil.diff(Utils.copy(clients), SetUtil.set(c));
  }

  public void addStore(final Store s) {

    stores = SetUtil.union(Utils.copy(stores), SetUtil.set(s));
  }

  public VDMSet getClients() {

    return Utils.copy(clients);
  }

  public VDMSet getStores() {

    return Utils.copy(stores);
  }

  public VDMSet getProductsAtStore(final Store store) {

    return store.getProductsAvailable();
  }

  public void buyProductInCash(
      final Product product, final Client client, final StoreCashier cashier, final Date date) {

    cashier.buyProductInCash(product);
    client.sellProduct(product);
    addPurchaseTransaction(date, client, SetUtil.set(product), cashier);
  }

  public void buyProductInCreditNotes(
      final Product product, final Client client, final StoreCashier cashier, final Date date) {

    cashier.buyProductInCreditNotes(product, client);
    client.sellProduct(product);
    addPurchaseTransaction(date, client, SetUtil.set(product), cashier);
  }

  public void sellProductInCash(
      final Product p, final Client c, final StoreCashier sc, final Date d) {

    sc.sellProduct(p);
    c.buyProduct(p);
    addSaleProductTransaction(d, c, SetUtil.set(p), SetUtil.set(), sc);
  }

  public void sellProductInCreditNotes(
      final Product p, final Client c, final StoreCashier sc, final Date d) {

    sc.sellProductInCreditNotes(p, c);
    c.buyProduct(p);
    addSaleProductTransaction(d, c, SetUtil.set(p), SetUtil.set(), sc);
  }

  public void sellProductInGiftCards(
      final Product p, final Client c, final StoreCashier sc, final VDMSet gc, final Date d) {

    sc.sellProduct(p);
    c.buyProduct(p);
    addSaleProductTransaction(d, c, SetUtil.set(p), Utils.copy(gc), sc);
    for (Iterator iterator_6 = gc.iterator(); iterator_6.hasNext(); ) {
      GiftCard giftCard = (GiftCard) iterator_6.next();
      useGiftCard(giftCard);
    }
  }

  public void sellGiftCard(
      final Client c, final StoreCashier sc, final Date d, final Number value) {

    GiftCard gc = sc.sellGiftCard(value);
    c.buyGiftCard(gc);
    addSaleGCTransaction(d, c, SetUtil.set(gc), sc);
  }

  public void activateGiftCard(final GiftCard giftCard) {

    activeGiftCards = SetUtil.union(Utils.copy(activeGiftCards), SetUtil.set(giftCard));
  }

  public void useGiftCard(final GiftCard giftCard) {

    activeGiftCards = SetUtil.diff(Utils.copy(activeGiftCards), SetUtil.set(giftCard));
  }

  private void addSaleProductTransaction(
      final Date d, final Client c, final VDMSet sp, final VDMSet gcs, final StoreCashier sc) {

    Transaction transaction = new Sale(d, c, Utils.copy(sp), Utils.copy(gcs), sc);
    transactions = SetUtil.union(Utils.copy(transactions), SetUtil.set(transaction));
  }

  private void addSaleGCTransaction(
      final Date d, final Client c, final VDMSet gcs, final StoreCashier sc) {

    Transaction transaction = new Sale(d, c, Utils.copy(gcs), sc);
    transactions = SetUtil.union(Utils.copy(transactions), SetUtil.set(transaction));
  }

  private void addPurchaseTransaction(
      final Date d, final Client c, final VDMSet sp, final StoreCashier sc) {

    Transaction transaction = new Purchase(d, c, Utils.copy(sp), sc);
    transactions = SetUtil.union(Utils.copy(transactions), SetUtil.set(transaction));
  }

  private Boolean hasCashierPerms() {

    return SetUtil.inSet(
        loggedInType,
        SetUtil.set(vdm.quotes.AdminQuote.getInstance(), vdm.quotes.CashierQuote.getInstance()));
  }

  private Boolean hasAdminPerms() {

    return Utils.equals(loggedInType, vdm.quotes.AdminQuote.getInstance());
  }

  public String toString() {

    return "Kid2Kid{"
        + "clients := "
        + Utils.toString(clients)
        + ", stores := "
        + Utils.toString(stores)
        + ", activeGiftCards := "
        + Utils.toString(activeGiftCards)
        + ", transactions := "
        + Utils.toString(transactions)
        + ", loggedInType := "
        + Utils.toString(loggedInType)
        + ", loggedInUsername := "
        + Utils.toString(loggedInUsername)
        + "}";
  }
}
