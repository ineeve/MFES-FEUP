package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Store {
  public static final Number CREDIT_NOTE_MULTIPLIER = 1.2;
  private String location;
  private VDMSet productsAvailable = SetUtil.set();
  private VDMSet productsSold = SetUtil.set();
  private VDMSet giftCardsSold = SetUtil.set();
  private VDMMap clientsCreditNotes = MapUtil.map();
  private VDMSet cashiers = SetUtil.set();

  public void cg_init_Store_1(final String storeLocation) {

    location = storeLocation;
    return;
  }

  public Store(final String storeLocation) {

    cg_init_Store_1(storeLocation);
  }

  public void addCashier(final StoreCashier cashier) {

    cashiers = SetUtil.union(Utils.copy(cashiers), SetUtil.set(cashier));
  }

  public void buyProductInCash(final Product p) {

    productsAvailable = SetUtil.union(Utils.copy(productsAvailable), SetUtil.set(p));
  }

  public void buyProductInCreditNotes(final Product p, final Number clientId) {

    buyProductInCash(p);
    addCreditNote(clientId, p);
  }

  public GiftCard sellGiftCard(final Number value) {

    GiftCard newGiftCard = new GiftCard(value);
    giftCardsSold = SetUtil.union(Utils.copy(giftCardsSold), SetUtil.set(newGiftCard));
    return newGiftCard;
  }

  public void sellProduct(final Product p) {

    productsAvailable = SetUtil.diff(Utils.copy(productsAvailable), SetUtil.set(p));
    productsSold = SetUtil.union(Utils.copy(productsSold), SetUtil.set(p));
  }

  public void sellProductInCreditNotes(final Product p, final Number clientId) {

    sellProduct(p);
    spendCreditNote(clientId, p.getSellPrice());
  }

  public Number getCreditNotesOfClient(final Number clientId) {

    return ((Number) Utils.get(clientsCreditNotes, clientId));
  }

  public VDMSet getProductsAvailable() {

    return Utils.copy(productsAvailable);
  }

  public VDMSet getCashiers() {

    return Utils.copy(cashiers);
  }

  public void removeCashier(final StoreCashier c) {

    cashiers = SetUtil.diff(Utils.copy(cashiers), SetUtil.set(c));
  }

  public void addCreditNote(final Number clientId, final Product p) {

    {
      if (!(SetUtil.inSet(clientId, MapUtil.dom(Utils.copy(clientsCreditNotes))))) {
        clientsCreditNotes =
            MapUtil.override(Utils.copy(clientsCreditNotes), MapUtil.map(new Maplet(clientId, 0L)));
      }
    }

    clientsCreditNotes =
        MapUtil.override(
            Utils.copy(clientsCreditNotes),
            MapUtil.map(
                new Maplet(
                    clientId,
                    ((Number) Utils.get(clientsCreditNotes, clientId)).doubleValue()
                        + p.getBuyPrice().doubleValue()
                            * Store.CREDIT_NOTE_MULTIPLIER.doubleValue())));
  }

  public void spendCreditNote(final Number clientId, final Number value) {

    clientsCreditNotes =
        MapUtil.override(
            Utils.copy(clientsCreditNotes),
            MapUtil.map(
                new Maplet(
                    clientId,
                    ((Number) Utils.get(clientsCreditNotes, clientId)).doubleValue()
                        - value.doubleValue())));
  }

  public Boolean hasProduct(final Product p) {

    return SetUtil.inSet(p, productsAvailable);
  }

  public Store() {}

  public static Boolean checkCreditNotes(
      final Number clientId,
      final Product p,
      final VDMMap newCreditNotes,
      final VDMMap oldCreditNotes) {

    if (!(SetUtil.inSet(clientId, MapUtil.dom(Utils.copy(oldCreditNotes))))) {
      return Utils.equals(
          ((Number) Utils.get(newCreditNotes, clientId)),
          p.getBuyPrice().doubleValue() * Store.CREDIT_NOTE_MULTIPLIER.doubleValue());

    } else {
      return Utils.equals(
          newCreditNotes,
          MapUtil.override(
              Utils.copy(oldCreditNotes),
              MapUtil.map(
                  new Maplet(
                      clientId,
                      ((Number) Utils.get(oldCreditNotes, clientId)).doubleValue()
                          + p.getBuyPrice().doubleValue()
                              * Store.CREDIT_NOTE_MULTIPLIER.doubleValue()))));
    }
  }

  public String toString() {

    return "Store{"
        + "CREDIT_NOTE_MULTIPLIER = "
        + Utils.toString(CREDIT_NOTE_MULTIPLIER)
        + ", location := "
        + Utils.toString(location)
        + ", productsAvailable := "
        + Utils.toString(productsAvailable)
        + ", productsSold := "
        + Utils.toString(productsSold)
        + ", giftCardsSold := "
        + Utils.toString(giftCardsSold)
        + ", clientsCreditNotes := "
        + Utils.toString(clientsCreditNotes)
        + ", cashiers := "
        + Utils.toString(cashiers)
        + "}";
  }
}
