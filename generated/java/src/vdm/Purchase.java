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

  public Purchase() {}

  public String toString() {

    return "Purchase{}";
  }
}
