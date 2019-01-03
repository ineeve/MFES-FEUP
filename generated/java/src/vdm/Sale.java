package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Sale extends Transaction {
  private VDMSet giftCardsUsed;
  private VDMSet giftCardsSold;
  /* Sale.vdmpp 20:9 */
  public Sale(
      final Date d,
      final Client c,
      final VDMSet p,
      final VDMSet cardsUsed,
      final StoreCashier authorizer) {

    throw new UnsupportedOperationException();
  }
  /* Sale.vdmpp 45:9 */
  public Purchase Purchase(final Number v, final Date d, final Client c, final VDMSet g) {

    throw new UnsupportedOperationException();
  }
  /* Sale.vdmpp 50:14 */
  public Number sumProductValues(final VDMSet pSet) {

    throw new UnsupportedOperationException();
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
