package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Client {
  private static Number idCounter = 0L;
  private Number id;
  private String name;
  private VDMSet boughtProducts = SetUtil.set();
  private VDMSet soldProducts = SetUtil.set();
  private VDMSet boughtGiftCards = SetUtil.set();
  /* Client.vdmpp 13:9 */
  public void cg_init_Client_1(final String nameSeq) {

    /* Client.vdmpp 15:5 */
    name = nameSeq;
    /* Client.vdmpp 15:19 */
    idCounter = Client.idCounter.longValue() + 1L;
    /* Client.vdmpp 15:46 */
    id = Client.idCounter;
    /* Client.vdmpp 15:63 */
    return;
  }
  /* Client.vdmpp 13:9 */
  public Client(final String nameSeq) {

    cg_init_Client_1(nameSeq);
  }
  /* Client.vdmpp 24:14 */
  public Number getId() {

    /* Client.vdmpp 26:3 */
    return id;
  }
  /* Client.vdmpp 34:9 */
  public void buyProduct(final Product product) {

    /* Client.vdmpp 37:3 */
    boughtProducts = SetUtil.union(Utils.copy(boughtProducts), SetUtil.set(product));
  }
  /* Client.vdmpp 49:9 */
  public void sellProduct(final Product product) {

    /* Client.vdmpp 51:3 */
    soldProducts = SetUtil.union(Utils.copy(soldProducts), SetUtil.set(product));
  }
  /* Client.vdmpp 57:9 */
  public void buyGiftCard(final GiftCard giftCard) {

    /* Client.vdmpp 59:3 */
    boughtGiftCards = SetUtil.union(Utils.copy(boughtGiftCards), SetUtil.set(giftCard));
  }
  /* Client.vdmpp 64:7 */
  private VDMSeq valuesFromGiftCards(final VDMSet g) {

    /* Client.vdmpp 66:9 */
    VDMSeq result = SeqUtil.seq();
    /* Client.vdmpp 67:3 */
    for (Iterator iterator_1 = g.iterator(); iterator_1.hasNext(); ) {
      GiftCard giftCard = (GiftCard) iterator_1.next();
      /* Client.vdmpp 68:5 */
      result = SeqUtil.conc(Utils.copy(result), SeqUtil.seq(giftCard.getValue()));
    }
    /* Client.vdmpp 69:3 */
    return Utils.copy(result);
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
        + ", boughtProducts := "
        + Utils.toString(boughtProducts)
        + ", soldProducts := "
        + Utils.toString(soldProducts)
        + ", boughtGiftCards := "
        + Utils.toString(boughtGiftCards)
        + "}";
  }
}
