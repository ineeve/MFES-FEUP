
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Kid2Kid {
  private VDMSet clients = SetUtil.set();
  private VDMSet stores = SetUtil.set();
  private VDMSet activeGiftCards = SetUtil.set();
  /* Kid2Kid.vdmpp 14:9 */
  public Kid2Kid() {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 23:9 */
  public void addClient(final Client c) {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 32:9 */
  public void addStore(final Store s) {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 37:9 */
  public VDMSet getClients() {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 42:9 */
  public VDMSet getStores() {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 49:9 */
  public void buyProductInCash(
      final Product product, final Client client, final StoreCashier cashier) {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 56:9 */
  public void buyProductInCreditNotes(
      final Product product, final Client client, final StoreCashier cashier) {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 63:9 */
  public void sellProduct(final Client client, final StoreCashier cashier) {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 68:9 */
  public void activateGiftCard(final GiftCard giftCard) {

    throw new UnsupportedOperationException();
  }
  /* Kid2Kid.vdmpp 73:9 */
  public void useGiftCard(final GiftCard giftCard) {

    throw new UnsupportedOperationException();
  }

  public String toString() {

    return "Kid2Kid{"
        + "clients := "
        + Utils.toString(clients)
        + ", stores := "
        + Utils.toString(stores)
        + ", activeGiftCards := "
        + Utils.toString(activeGiftCards)
        + "}";
  }
}
