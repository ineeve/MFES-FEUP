package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Purchase extends Transaction {
  /* Purchase.vdmpp 8:9 */
  public void cg_init_Purchase_1(
      final Date d, final Client c, final VDMSet ps, final StoreCashier sc) {

    /* Purchase.vdmpp 11:4 */
    date = d;
    /* Purchase.vdmpp 12:4 */
    client = c;
    /* Purchase.vdmpp 13:4 */
    productsTransacted = Utils.copy(ps);
    /* Purchase.vdmpp 14:4 */
    storeAuthorizer = sc;
    /* Purchase.vdmpp 15:4 */
    return;
  }
  /* Purchase.vdmpp 8:9 */
  public Purchase(final Date d, final Client c, final VDMSet ps, final StoreCashier sc) {

    cg_init_Purchase_1(d, c, Utils.copy(ps), sc);
  }
  /* Purchase.vdmpp 1:7 */
  public Purchase() {}

  public String toString() {

    return "Purchase{}";
  }
}
