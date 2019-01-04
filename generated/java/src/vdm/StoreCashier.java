package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StoreCashier {
  private String name;
  private Store store;

  public void cg_init_StoreCashier_1(final String n, final Store w) {

    name = n;
    store = w;
    return;
  }

  public StoreCashier(final String n, final Store w) {

    cg_init_StoreCashier_1(n, w);
  }

  public String getName() {

    return name;
  }

  public void buyProductInCash(final Product p) {

    store.buyProductInCash(p);
  }

  public void buyProductInCreditNotes(final Product p, final Client client) {

    store.buyProductInCreditNotes(p, client.getId());
  }

  public void sellProduct(final Product p) {

    store.sellProduct(p);
  }

  public void sellProductInCreditNotes(final Product p, final Client client) {

    store.sellProductInCreditNotes(p, client.getId());
  }

  public GiftCard sellGiftCard(final Number value) {

    return store.sellGiftCard(value);
  }

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
