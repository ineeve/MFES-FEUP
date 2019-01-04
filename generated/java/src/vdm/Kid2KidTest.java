package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Kid2KidTest {
  private Kid2Kid kid2kid = new Kid2Kid();
  private Client client = new Client("abc");
  private Store store = new Store("Porto");
  private StoreCashier cashier;
  private Date today = new Date(4L, 1L, 2019L);

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testAddClient() {

    assertTrue(Utils.equals(kid2kid.getClients().size(), 0L));
    kid2kid.addClient(client);
    assertTrue(Utils.equals(kid2kid.getClients().size(), 1L));
  }

  private void testAddStore() {

    assertTrue(Utils.equals(kid2kid.getStores().size(), 0L));
    kid2kid.addStore(store);
    assertTrue(Utils.equals(kid2kid.getStores().size(), 1L));
  }

  private void testAddCashierToStore() {

    cashier = new StoreCashier("Joao", store);
    store.addCashier(cashier);
    assertTrue(Utils.equals(store.getCashiers().size(), 1L));
  }

  private void testStoreBuyProductInCash() {

    Product p = new Toy(5L, vdm.quotes.CARSQuote.getInstance());
    assertTrue(!(SetUtil.inSet(p, store.getProductsAvailable())));
    assertTrue(!(SetUtil.inSet(p, client.getProductsSold())));
    kid2kid.buyProductInCash(p, client, cashier, today);
    assertTrue(SetUtil.inSet(p, store.getProductsAvailable()));
    assertTrue(SetUtil.inSet(p, client.getProductsSold()));
  }

  private void testStoreBuyProductInCreditNotes() {

    Product p = new Toy(2L, vdm.quotes.PUZZLESQuote.getInstance());
    assertTrue(!(SetUtil.inSet(p, store.getProductsAvailable())));
    assertTrue(!(SetUtil.inSet(p, client.getProductsSold())));
    kid2kid.buyProductInCreditNotes(p, client, cashier, today);
    assertTrue(SetUtil.inSet(p, store.getProductsAvailable()));
    assertTrue(SetUtil.inSet(p, client.getProductsSold()));
    assertTrue(store.getCreditNotesOfClient(client.getId()).longValue() > 0L);
  }

  public static void main() {

    Kid2KidTest kid2KidTest = new Kid2KidTest();
    kid2KidTest.testAddClient();
    kid2KidTest.testAddStore();
    kid2KidTest.testAddCashierToStore();
    kid2KidTest.testStoreBuyProductInCash();
  }

  public Kid2KidTest() {}

  public String toString() {

    return "Kid2KidTest{"
        + "kid2kid := "
        + Utils.toString(kid2kid)
        + ", client := "
        + Utils.toString(client)
        + ", store := "
        + Utils.toString(store)
        + ", cashier := "
        + Utils.toString(cashier)
        + ", today := "
        + Utils.toString(today)
        + "}";
  }
}
