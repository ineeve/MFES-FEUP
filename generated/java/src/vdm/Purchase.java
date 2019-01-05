package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Purchase extends Transaction {
  public void cg_init_Purchase_1(
      final Date d, final Client c, final VDMSet ps, final StoreCashier sc) {

    date = d;
    client = c;
    productsTransacted = Utils.copy(ps);
    storeAuthorizer = sc;
    return;
  }

  public Purchase(final Date d, final Client c, final VDMSet ps, final StoreCashier sc) {

    cg_init_Purchase_1(d, c, Utils.copy(ps), sc);
  }

  public Number getValue() {

    return getSumProductValues();
  }

  protected Number sumProductValues(final VDMSet pSet) {

    Number result = 0L;
    for (Iterator iterator_9 = pSet.iterator(); iterator_9.hasNext(); ) {
      Product p = (Product) iterator_9.next();
      result = result.longValue() + p.getBuyPrice().doubleValue();
    }
    return result;
  }

  public Purchase() {}

  public String toString() {

    return "Purchase{}";
  }
}
