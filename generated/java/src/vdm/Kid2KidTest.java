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
  private VDMSeq products = SeqUtil.seq();

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void loginAdmin() {

    assertTrue(Utils.equals(kid2kid.login("Admin"), vdm.quotes.AdminQuote.getInstance()));
  }

  private void loginCashier(final String storeName, final String cashierName) {

    assertTrue(
        Utils.equals(kid2kid.login(storeName, cashierName), vdm.quotes.CashierQuote.getInstance()));
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

  private void testAddCashierToStore(final String name) {

    Number prevNumCashiers = store.getCashiers().size();
    cashier = new StoreCashier(name, store);
    store.addCashier(cashier);
    assertTrue(Utils.equals(store.getCashiers().size(), prevNumCashiers.longValue() + 1L));
  }

  private void testStoreBuyProductsInCash() {

    Product toy =
        new Toy(vdm.quotes.NewQuote.getInstance(), 5L, vdm.quotes.CarsQuote.getInstance());
    Product gear =
        new Gear(
            vdm.quotes.High_UseQuote.getInstance(), 1L, vdm.quotes.BathtubsQuote.getInstance());
    Product furniture =
        new Furniture(vdm.quotes.NewQuote.getInstance(), vdm.quotes.BedsQuote.getInstance());
    products = SeqUtil.seq(toy, gear, furniture);
    assertTrue(
        Utils.empty(
            SetUtil.intersect(SeqUtil.elems(Utils.copy(products)), store.getProductsAvailable())));
    assertTrue(
        Utils.empty(
            SetUtil.intersect(SeqUtil.elems(Utils.copy(products)), client.getProductsSold())));
    kid2kid.buyProductInCash(toy, client, cashier, today);
    kid2kid.buyProductInCash(gear, client, cashier, today);
    kid2kid.buyProductInCash(furniture, client, cashier, today);
    assertTrue(SetUtil.subset(SeqUtil.elems(Utils.copy(products)), store.getProductsAvailable()));
    assertTrue(SetUtil.subset(SeqUtil.elems(Utils.copy(products)), client.getProductsSold()));
  }

  private void testStoreBuyProductsInCreditNotes() {

    Product boots =
        new Footwear(
            vdm.quotes.Low_UseQuote.getInstance(), 20L, vdm.quotes.BootsQuote.getInstance());
    Product jeans =
        new Clothing(
            vdm.quotes.Low_UseQuote.getInstance(), 1L, 2L, vdm.quotes.JeansQuote.getInstance());
    VDMSet productsSet = SetUtil.set(boots, jeans);
    assertTrue(
        Utils.empty(SetUtil.intersect(Utils.copy(productsSet), store.getProductsAvailable())));
    assertTrue(Utils.empty(SetUtil.intersect(Utils.copy(productsSet), client.getProductsSold())));
    kid2kid.buyProductInCreditNotes(boots, client, cashier, today);
    kid2kid.buyProductInCreditNotes(jeans, client, cashier, today);
    assertTrue(SetUtil.subset(productsSet, store.getProductsAvailable()));
    assertTrue(SetUtil.subset(productsSet, client.getProductsSold()));
    assertTrue(
        Utils.equals(
            store.getCreditNotesOfClient(client.getId()),
            boots.getCreditNotesValue().doubleValue() + jeans.getCreditNotesValue().doubleValue()));
  }

  private void testGetCashiers(final Number expectedNumber) {

    assertTrue(Utils.equals(kid2kid.getCashiers().size(), expectedNumber));
  }

  private void testGetCashierNames(final VDMSet namesSet) {

    assertTrue(Utils.empty(SetUtil.diff(Utils.copy(namesSet), kid2kid.getCashierNames())));
  }

  public void testGetProductsAtStore(final Number expectedNum) {

    assertTrue(Utils.equals(kid2kid.getProductsAtStore(store).size(), expectedNum));
  }

  public void testStoreGiftCards() {

    GiftCard gc = kid2kid.sellGiftCard(client, cashier, today, 40L);
    assertTrue(Utils.equals(kid2kid.getActiveGiftCards().size(), 1L));
    assertTrue(SetUtil.inSet(gc, client.getGiftCardsBought()));
    kid2kid.sellProductInGiftCards(
        ((Product) Utils.get(products, 1L)), client, cashier, SetUtil.set(gc), today);
    assertTrue(Utils.equals(kid2kid.getActiveGiftCards().size(), 0L));
    assertTrue(SetUtil.inSet(((Product) Utils.get(products, 1L)), client.getProductsBought()));
  }

  public void testStoreSellProductInCash() {

    assertTrue(SetUtil.inSet(((Product) Utils.get(products, 2L)), store.getProductsAvailable()));
    kid2kid.sellProductInCash(((Product) Utils.get(products, 2L)), client, cashier, today);
    assertTrue(!(SetUtil.inSet(((Product) Utils.get(products, 2L)), store.getProductsAvailable())));
    assertTrue(SetUtil.inSet(((Product) Utils.get(products, 2L)), client.getProductsBought()));
  }

  public void testStoreSellProductInCreditNotes() {

    Number clientPrevCredit = store.getCreditNotesOfClient(client.getId());
    assertTrue(clientPrevCredit.doubleValue() > 0L);
    assertTrue(SetUtil.inSet(((Product) Utils.get(products, 3L)), store.getProductsAvailable()));
    kid2kid.sellProductInCreditNotes(((Product) Utils.get(products, 3L)), client, cashier, today);
    assertTrue(!(SetUtil.inSet(((Product) Utils.get(products, 3L)), store.getProductsAvailable())));
    assertTrue(SetUtil.inSet(((Product) Utils.get(products, 3L)), client.getProductsBought()));
    assertTrue(
        Utils.equals(
            store.getCreditNotesOfClient(client.getId()),
            clientPrevCredit.doubleValue()
                - ((Product) Utils.get(products, 3L)).getSellPrice().doubleValue()));
  }

  public void testAdminOperations() {

    loginAdmin();
    testAddClient();
    testAddStore();
    testAddCashierToStore("Joao");
    testAddCashierToStore("Renato");
    testGetCashiers(2L);
    testGetCashierNames(SetUtil.set("Joao", "Renato"));
  }

  public void testCashierOperations() {

    loginCashier("Porto", "Joao");
    testStoreBuyProductsInCash();
    testStoreBuyProductsInCreditNotes();
    testGetProductsAtStore(5L);
    testStoreGiftCards();
    testStoreSellProductInCash();
    testStoreSellProductInCreditNotes();
  }

  public static void main() {

    Kid2KidTest kid2KidTest = new Kid2KidTest();
    kid2KidTest.testAdminOperations();
    kid2KidTest.testCashierOperations();
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
        + ", products := "
        + Utils.toString(products)
        + "}";
  }
}
