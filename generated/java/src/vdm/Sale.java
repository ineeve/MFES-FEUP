package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Sale extends Transaction {
  private VDMSet giftCardsUsed;
  private VDMSet giftCardsSold;

  public void cg_init_Sale_2(final Date d, final Client c, final VDMSet g, final StoreCashier sc) {

    value = sumGCValues(Utils.copy(g));
    date = d;
    client = c;
    giftCardsSold = Utils.copy(g);
    storeAuthorizer = sc;
    return;
  }

  public void cg_init_Sale_1(
      final Date d, final Client c, final VDMSet p, final VDMSet cardsUsed, final StoreCashier sc) {

    date = d;
    client = c;
    productsTransacted = Utils.copy(p);
    giftCardsUsed = Utils.copy(cardsUsed);
    storeAuthorizer = sc;
    value = sumProductValues(Utils.copy(p));
    return;
  }

  public Sale(
      final Date d, final Client c, final VDMSet p, final VDMSet cardsUsed, final StoreCashier sc) {

    cg_init_Sale_1(d, c, Utils.copy(p), Utils.copy(cardsUsed), sc);
  }

  public Sale(final Date d, final Client c, final VDMSet g, final StoreCashier sc) {

    cg_init_Sale_2(d, c, Utils.copy(g), sc);
  }

  public Number sumProductValues(final VDMSet pSet) {

    Number result = 0L;
    for (Iterator iterator_5 = pSet.iterator(); iterator_5.hasNext(); ) {
      Product p = (Product) iterator_5.next();
      result = result.longValue() + p.getSellPrice().longValue();
    }
    return result;
  }

  public Number sumGCValues(final VDMSet gcSet) {

    Number result = 0L;
    for (Iterator iterator_6 = gcSet.iterator(); iterator_6.hasNext(); ) {
      GiftCard g = (GiftCard) iterator_6.next();
      result = result.longValue() + g.getValue().longValue();
    }
    return result;
  }

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
