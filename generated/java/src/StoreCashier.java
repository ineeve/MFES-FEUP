
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StoreCashier {
  private String name;
  private Store store;
  private VDMSet transactions = SetUtil.set();
  /* StoreCashier.vdmpp 11:9 */
  public StoreCashier(final String n, final Store w) {

    throw new UnsupportedOperationException();
  }
  /* StoreCashier.vdmpp 18:9 */
  public void buyProductInCash(final Product p, final Client client) {

    throw new UnsupportedOperationException();
  }
  /* StoreCashier.vdmpp 28:9 */
  public void buyProductInCreditNotes(final Product p, final Client client) {

    throw new UnsupportedOperationException();
  }
  /* StoreCashier.vdmpp 39:9 */
  public void sellProductInCash(final Product p, final Client client) {

    throw new UnsupportedOperationException();
  }
  /* StoreCashier.vdmpp 49:9 */
  public void sellProductInCreditNotes(final Product p, final Client client) {

    throw new UnsupportedOperationException();
  }
  /* StoreCashier.vdmpp 56:9 */
  public void sellProductInGiftCards(final Product p, final Client client) {

    throw new UnsupportedOperationException();
  }
  /* StoreCashier.vdmpp 1:7 */
  public StoreCashier() {}

  public String toString() {

    return "StoreCashier{"
        + "name := "
        + Utils.toString(name)
        + ", store := "
        + Utils.toString(store)
        + ", transactions := "
        + Utils.toString(transactions)
        + "}";
  }
}
