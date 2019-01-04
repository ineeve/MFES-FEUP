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
  /* Store.vdmpp 16:9 */
  public void cg_init_Store_1(final String storeLocation) {

    /* Store.vdmpp 18:4 */
    location = storeLocation;
    /* Store.vdmpp 19:3 */
    return;
  }
  /* Store.vdmpp 16:9 */
  public Store(final String storeLocation) {

    cg_init_Store_1(storeLocation);
  }
  /* Store.vdmpp 28:9 */
  public void buyProductInCash(final Product p) {

    /* Store.vdmpp 30:3 */
    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 34:9 */
  public void buyProductInCreditNotes(final Product p, final Number clientId) {

    /* Store.vdmpp 36:3 */
    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 41:9 */
  public GiftCard sellGiftCard(final Number value) {

    /* Store.vdmpp 44:7 */
    GiftCard newGiftCard = new GiftCard(value);
    /* Store.vdmpp 45:3 */
    giftCardsSold = SetUtil.union(Utils.copy(giftCardsSold), SetUtil.set(newGiftCard));
    /* Store.vdmpp 46:3 */
    return newGiftCard;
  }
  /* Store.vdmpp 51:9 */
  public void sellProduct(final Product p) {

    /* Store.vdmpp 54:3 */
    productsAvailable = SetUtil.diff(Utils.copy(productsAvailable), SetUtil.set(p));
    /* Store.vdmpp 55:3 */
    productsSold = SetUtil.union(Utils.copy(productsSold), SetUtil.set(p));
  }
  /* Store.vdmpp 60:9 */
  public void sellProductInCreditNotes(final Product p, final Number clientId) {

    /* Store.vdmpp 63:3 */
    sellProduct(p);
    /* Store.vdmpp 64:3 */
    spendCreditNote(clientId, p.getSellPrice());
  }
  /* Store.vdmpp 71:14 */
  public Number getCreditNotesOfClient(final Number clientId) {

    /* Store.vdmpp 73:3 */
    return ((Number) Utils.get(clientsCreditNotes, clientId));
  }
  /* Store.vdmpp 77:9 */
  public VDMSet getProductsAvailable() {

    /* Store.vdmpp 79:3 */
    return Utils.copy(productsAvailable);
  }
  /* Store.vdmpp 83:9 */
  public VDMSet getCashiers() {

    /* Store.vdmpp 85:3 */
    return Utils.copy(cashiers);
  }
  /* Store.vdmpp 89:9 */
  public void addCreditNote(final Number clientId, final Product p) {

    /* Store.vdmpp 92:4 */
    {
      /* Store.vdmpp 92:5 */
      if (!(SetUtil.inSet(clientId, MapUtil.dom(Utils.copy(clientsCreditNotes))))) {
        clientsCreditNotes =
            MapUtil.override(Utils.copy(clientsCreditNotes), MapUtil.map(new Maplet(clientId, 0L)));
      }
    }

    /* Store.vdmpp 95:4 */
    clientsCreditNotes =
        MapUtil.override(
            Utils.copy(clientsCreditNotes),
            MapUtil.map(
                new Maplet(
                    clientId,
                    ((Number) Utils.get(clientsCreditNotes, clientId)).longValue()
                        + p.getBuyPrice().longValue()
                            * Store.CREDIT_NOTE_MULTIPLIER.doubleValue())));
  }
  /* Store.vdmpp 105:9 */
  public void spendCreditNote(final Number clientId, final Number value) {

    /* Store.vdmpp 107:4 */
    clientsCreditNotes =
        MapUtil.override(
            Utils.copy(clientsCreditNotes),
            MapUtil.map(
                new Maplet(
                    clientId,
                    ((Number) Utils.get(clientsCreditNotes, clientId)).longValue()
                        - value.longValue())));
  }
  /* Store.vdmpp 111:14 */
  public Boolean hasProduct(final Product p) {

    /* Store.vdmpp 113:3 */
    return SetUtil.inSet(p, productsAvailable);
  }
  /* Store.vdmpp 1:7 */
  public Store() {}

  /* Store.vdmpp 117:9 */
  public static Boolean checkCreditNotes(
      final Number clientId,
      final Product p,
      final VDMMap newCreditNotes,
      final VDMMap oldCreditNotes) {

    /* Store.vdmpp 119:18 */
    return Utils.equals(
        newCreditNotes,
        MapUtil.override(
            Utils.copy(oldCreditNotes),
            MapUtil.map(
                new Maplet(
                    clientId,
                    ((Number) Utils.get(oldCreditNotes, clientId)).longValue()
                        + p.getBuyPrice().longValue()
                            * Store.CREDIT_NOTE_MULTIPLIER.doubleValue()))));
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
