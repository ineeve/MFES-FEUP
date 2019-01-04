package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Sale extends Transaction {
  private VDMSet giftCardsUsed;
  private VDMSet giftCardsSold;
  /* Sale.vdmpp 46:9 */
  public void cg_init_Sale_2(final Date d, final Client c, final VDMSet g, final StoreCashier sc) {

    /* Sale.vdmpp 48:3 */
    throw new UnsupportedOperationException();
  }
  /* Sale.vdmpp 20:9 */
  public void cg_init_Sale_1(
      final Date d, final Client c, final VDMSet p, final VDMSet cardsUsed, final StoreCashier sc) {

    /* Sale.vdmpp 23:3 */
    date = d;
    /* Sale.vdmpp 24:3 */
    client = c;
    /* Sale.vdmpp 25:3 */
    productsTransacted = Utils.copy(p);
    /* Sale.vdmpp 26:3 */
    giftCardsUsed = Utils.copy(cardsUsed);
    /* Sale.vdmpp 27:3 */
    storeAuthorizer = sc;
    /* Sale.vdmpp 28:3 */
    value = sumProductValues(Utils.copy(p));
    /* Sale.vdmpp 29:3 */
    return;
  }
  /* Sale.vdmpp 20:9 */
  public Sale(
      final Date d, final Client c, final VDMSet p, final VDMSet cardsUsed, final StoreCashier sc) {

    cg_init_Sale_1(d, c, Utils.copy(p), Utils.copy(cardsUsed), sc);
  }
  /* Sale.vdmpp 46:9 */
  public Sale(final Date d, final Client c, final VDMSet g, final StoreCashier sc) {

    cg_init_Sale_2(d, c, Utils.copy(g), sc);
  }
  /* Sale.vdmpp 52:14 */
  public Number sumProductValues(final VDMSet pSet) {

    /* Sale.vdmpp 55:7 */
    Number result = 0L;
    /* Sale.vdmpp 56:3 */
    for (Iterator iterator_3 = pSet.iterator(); iterator_3.hasNext(); ) {
      Product p = (Product) iterator_3.next();
      /* Sale.vdmpp 58:4 */
      result = result.longValue() + p.getSellPrice().longValue();
    }
    /* Sale.vdmpp 60:3 */
    return result;
  }
  /* Sale.vdmpp 65:14 */
  public Number sumGCValues(final VDMSet gcSet) {

    /* Sale.vdmpp 68:7 */
    Number result = 0L;
    /* Sale.vdmpp 69:3 */
    for (Iterator iterator_4 = gcSet.iterator(); iterator_4.hasNext(); ) {
      GiftCard g = (GiftCard) iterator_4.next();
      /* Sale.vdmpp 71:4 */
      result = result.longValue() + g.getValue().longValue();
    }
    /* Sale.vdmpp 73:3 */
    return result;
  }
  /* Sale.vdmpp 2:7 */
  public Sale() {}

  public String toString() {

    return "Sale{"
        + "giftCardsUsed := "
        + Utils.toString(giftCardsUsed)
        + ", giftCardsSold := "
        + Utils.toString(giftCardsSold)
        + "}";
  }
}
