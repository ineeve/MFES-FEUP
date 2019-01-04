package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Kid2Kid {
  private VDMSet clients = SetUtil.set();
  private VDMSet stores = SetUtil.set();
  private VDMSet activeGiftCards = SetUtil.set();
  private VDMSet transactions = SetUtil.set();
  /* Kid2Kid.vdmpp 15:9 */
  public void cg_init_Kid2Kid_1() {

    /* Kid2Kid.vdmpp 17:3 */
    return;
  }
  /* Kid2Kid.vdmpp 15:9 */
  public Kid2Kid() {

    cg_init_Kid2Kid_1();
  }
  /* Kid2Kid.vdmpp 25:9 */
  public void addClient(final Client c) {

    /* Kid2Kid.vdmpp 27:3 */
    clients = SetUtil.union(Utils.copy(clients), SetUtil.set(c));
  }
  /* Kid2Kid.vdmpp 35:9 */
  public void addStore(final Store s) {

    /* Kid2Kid.vdmpp 37:3 */
    stores = SetUtil.union(Utils.copy(stores), SetUtil.set(s));
  }
  /* Kid2Kid.vdmpp 41:9 */
  public VDMSet getClients() {

    /* Kid2Kid.vdmpp 43:3 */
    return Utils.copy(clients);
  }
  /* Kid2Kid.vdmpp 47:9 */
  public VDMSet getStores() {

    /* Kid2Kid.vdmpp 49:3 */
    return Utils.copy(stores);
  }
  /* Kid2Kid.vdmpp 55:9 */
  public void buyProductInCash(
      final Product product, final Client client, final StoreCashier cashier, final Date date) {

    /* Kid2Kid.vdmpp 58:3 */
    cashier.buyProductInCash(product);
    /* Kid2Kid.vdmpp 59:3 */
    client.sellProduct(product);
    /* Kid2Kid.vdmpp 60:3 */
    addPurchaseTransaction(date, client, SetUtil.set(product), cashier);
  }
  /* Kid2Kid.vdmpp 67:9 */
  public void buyProductInCreditNotes(
      final Product product, final Client client, final StoreCashier cashier, final Date date) {

    /* Kid2Kid.vdmpp 70:3 */
    cashier.buyProductInCreditNotes(product, client);
    /* Kid2Kid.vdmpp 71:3 */
    client.sellProduct(product);
    /* Kid2Kid.vdmpp 72:3 */
    addPurchaseTransaction(date, client, SetUtil.set(product), cashier);
  }
  /* Kid2Kid.vdmpp 79:9 */
  public void sellProductInCash(
      final Product p, final Client c, final StoreCashier sc, final Date d) {

    /* Kid2Kid.vdmpp 82:3 */
    sc.sellProduct(p);
    /* Kid2Kid.vdmpp 83:3 */
    c.buyProduct(p);
    /* Kid2Kid.vdmpp 84:3 */
    addSaleProductTransaction(d, c, SetUtil.set(p), SetUtil.set(), sc);
  }
  /* Kid2Kid.vdmpp 89:9 */
  public void sellProductInCreditNotes(
      final Product p, final Client c, final StoreCashier sc, final Date d) {

    /* Kid2Kid.vdmpp 92:3 */
    sc.sellProductInCreditNotes(p, c);
    /* Kid2Kid.vdmpp 93:3 */
    c.buyProduct(p);
    /* Kid2Kid.vdmpp 94:3 */
    addSaleProductTransaction(d, c, SetUtil.set(p), SetUtil.set(), sc);
  }
  /* Kid2Kid.vdmpp 99:9 */
  public void sellProductInGiftCards(
      final Product p, final Client c, final StoreCashier sc, final VDMSet gc, final Date d) {

    /* Kid2Kid.vdmpp 102:3 */
    sc.sellProduct(p);
    /* Kid2Kid.vdmpp 103:3 */
    c.buyProduct(p);
    /* Kid2Kid.vdmpp 104:3 */
    addSaleProductTransaction(d, c, SetUtil.set(p), Utils.copy(gc), sc);
    /* Kid2Kid.vdmpp 105:3 */
    for (Iterator iterator_2 = gc.iterator(); iterator_2.hasNext(); ) {
      GiftCard giftCard = (GiftCard) iterator_2.next();
      useGiftCard(giftCard);
    }
  }
  /* Kid2Kid.vdmpp 111:2 */
  private void sellGiftCard(
      final Client c, final StoreCashier sc, final Date d, final Number value) {

    /* Kid2Kid.vdmpp 114:7 */
    GiftCard gc = sc.sellGiftCard(value);
    /* Kid2Kid.vdmpp 115:3 */
    c.buyGiftCard(gc);
    /* Kid2Kid.vdmpp 116:3 */
    addSaleGCTransaction(d, c, SetUtil.set(gc), sc);
  }
  /* Kid2Kid.vdmpp 121:9 */
  public void activateGiftCard(final GiftCard giftCard) {

    /* Kid2Kid.vdmpp 123:3 */
    activeGiftCards = SetUtil.union(Utils.copy(activeGiftCards), SetUtil.set(giftCard));
  }
  /* Kid2Kid.vdmpp 127:9 */
  public void useGiftCard(final GiftCard giftCard) {

    /* Kid2Kid.vdmpp 129:3 */
    activeGiftCards = SetUtil.diff(Utils.copy(activeGiftCards), SetUtil.set(giftCard));
  }
  /* Kid2Kid.vdmpp 133:10 */
  private void addSaleProductTransaction(
      final Date d, final Client c, final VDMSet sp, final VDMSet gcs, final StoreCashier sc) {

    /* Kid2Kid.vdmpp 136:7 */
    Transaction transaction = new Sale(d, c, Utils.copy(sp), Utils.copy(gcs), sc);
    /* Kid2Kid.vdmpp 137:3 */
    transactions = SetUtil.union(Utils.copy(transactions), SetUtil.set(transaction));
  }
  /* Kid2Kid.vdmpp 142:10 */
  private void addSaleGCTransaction(
      final Date d, final Client c, final VDMSet gcs, final StoreCashier sc) {

    /* Kid2Kid.vdmpp 145:7 */
    Transaction transaction = new Sale(d, c, Utils.copy(gcs), sc);
    /* Kid2Kid.vdmpp 146:3 */
    transactions = SetUtil.union(Utils.copy(transactions), SetUtil.set(transaction));
  }
  /* Kid2Kid.vdmpp 151:10 */
  private void addPurchaseTransaction(
      final Date d, final Client c, final VDMSet sp, final StoreCashier sc) {

    /* Kid2Kid.vdmpp 154:7 */
    Transaction transaction = new Purchase(d, c, Utils.copy(sp), sc);
    /* Kid2Kid.vdmpp 155:3 */
    transactions = SetUtil.union(Utils.copy(transactions), SetUtil.set(transaction));
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
        + "}";
  }
}
