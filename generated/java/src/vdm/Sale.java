package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Sale extends Transaction {
  private VDMSet giftCardsUsed = SetUtil.set();
  private VDMSet giftCardsSold = SetUtil.set();

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

  public VDMSet getGiftCardsUsed() {

    return Utils.copy(giftCardsUsed);
  }

  public VDMSet getGiftCardsSold() {

    return Utils.copy(giftCardsSold);
  }

  public Number getValue() {

    return getSumProductValues().longValue() + sumGCValues(Utils.copy(giftCardsSold)).longValue();
  }

  protected Number sumProductValues(final VDMSet pSet) {

    Number result = 0L;
    for (Iterator iterator_8 = pSet.iterator(); iterator_8.hasNext(); ) {
      Product p = (Product) iterator_8.next();
      result = result.longValue() + p.getSellPrice().doubleValue();
    }
    return result;
  }

  private Number sumGCValues(final VDMSet gcSet) {

    Number result = 0L;
    for (Iterator iterator_9 = gcSet.iterator(); iterator_9.hasNext(); ) {
      GiftCard g = (GiftCard) iterator_9.next();
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
