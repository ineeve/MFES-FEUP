package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Client {
  private static Number idCounter = 0L;
  private Number id;
  private String name;
  private VDMSet ownedGiftCards = SetUtil.set();
  private VDMSet transactions = SetUtil.set();
  /* Client.vdmpp 12:9 */
  public Client(final String nameSeq) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 18:9 */
  public Number getId() {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 29:9 */
  public GiftCard buyGiftCard(final Number value) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 45:9 */
  public void removeGiftCard(final GiftCard giftCard) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 55:9 */
  public void buyProduct(final Product product, final VDMSet giftCardsUsed) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 71:9 */
  public void sellProduct(final Product product) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 81:14 */
  public Boolean ownsGiftCard(final GiftCard giftCard) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 91:14 */
  public Boolean ownsGiftCards(final VDMSet giftCards) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 97:6 */
  private VDMSeq valuesFromGiftCards(final VDMSet g) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 105:6 */
  private VDMSet getSoldProducts(final VDMSet tSet) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 115:6 */
  private VDMSet getBoughtProducts(final VDMSet tSet) {

    throw new UnsupportedOperationException();
  }
  /* Client.vdmpp 1:7 */
  public Client() {}

  public String toString() {

    return "Client{"
        + "idCounter := "
        + Utils.toString(idCounter)
        + ", id := "
        + Utils.toString(id)
        + ", name := "
        + Utils.toString(name)
        + ", ownedGiftCards := "
        + Utils.toString(ownedGiftCards)
        + ", transactions := "
        + Utils.toString(transactions)
        + "}";
  }
}
