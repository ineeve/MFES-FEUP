package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StoreCashier {
  private String name;
  private Store store;
  /* StoreCashier.vdmpp 10:9 */
  public void cg_init_StoreCashier_1(final String n, final Store w) {

    /* StoreCashier.vdmpp 12:4 */
    name = n;
    /* StoreCashier.vdmpp 12:15 */
    store = w;
    /* StoreCashier.vdmpp 12:27 */
    return;
  }
  /* StoreCashier.vdmpp 10:9 */
  public StoreCashier(final String n, final Store w) {

    cg_init_StoreCashier_1(n, w);
  }
  /* StoreCashier.vdmpp 18:9 */
  public void buyProductInCash(final Product p) {

    /* StoreCashier.vdmpp 21:3 */
    store.buyProductInCash(p);
  }
  /* StoreCashier.vdmpp 28:9 */
  public void buyProductInCreditNotes(final Product p, final Client client) {

    /* StoreCashier.vdmpp 31:3 */
    store.buyProductInCreditNotes(p, client.getId());
  }
  /* StoreCashier.vdmpp 39:9 */
  public void sellProduct(final Product p) {

    /* StoreCashier.vdmpp 42:3 */
    store.sellProduct(p);
  }
  /* StoreCashier.vdmpp 49:9 */
  public void sellProductInCreditNotes(final Product p, final Client client) {

    /* StoreCashier.vdmpp 52:4 */
    store.sellProductInCreditNotes(p, client.getId());
  }
  /* StoreCashier.vdmpp 57:9 */
  public GiftCard sellGiftCard(final Number value) {

    /* StoreCashier.vdmpp 59:3 */
    return store.sellGiftCard(value);
  }
  /* StoreCashier.vdmpp 1:7 */
  public StoreCashier() {}

  public String toString() {

    return "StoreCashier{"
        + "name := "
        + Utils.toString(name)
        + ", store := "
        + Utils.toString(store)
        + "}";
  }
}
