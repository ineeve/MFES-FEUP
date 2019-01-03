
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Store {
  public static final Number CREDIT_NOTE_MULTIPLIER = 1.2;
  private String location;
  private VDMSet productsAvailable = SetUtil.set();
  private VDMSet productsSold = SetUtil.set();
  private VDMMap clientsCreditNotes = MapUtil.map();
  private VDMSet cashiers = SetUtil.set();
  /* Store.vdmpp 15:9 */
  public Store(final String storeLocation) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 26:9 */
  public void buyProductInCash(final Product p) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 31:9 */
  public void buyProductInCreditNotes(final Product p, final Number clientId) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 37:9 */
  public void sellProduct(final Product p) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 42:9 */
  public Number getCreditNotesOfClient(final Number clientId) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 47:9 */
  public VDMSet getProductsAvailable() {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 52:9 */
  public VDMSet getCashiers() {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 57:9 */
  public void addCreditNote(final Number clientId, final Product p) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 72:9 */
  public void spendCreditNote(final Number clientId, final Number value) {

    throw new UnsupportedOperationException();
  }
  /* Store.vdmpp 1:7 */
  public Store() {}

  /* Store.vdmpp 78:9 */
  public static Boolean checkCreditNotes(
      final Number clientId,
      final Product p,
      final VDMMap newCreditNotes,
      final VDMMap oldCreditNotes) {

    throw new UnsupportedOperationException();
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
        + ", clientsCreditNotes := "
        + Utils.toString(clientsCreditNotes)
        + ", cashiers := "
        + Utils.toString(cashiers)
        + "}";
  }
}
