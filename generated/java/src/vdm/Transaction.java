package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Transaction {
  protected Number value;
  protected Date date;
  protected Client client;
  protected VDMSet productsTransacted;
  protected StoreCashier storeAuthorizer;
  /* Transaction.vdmpp 15:13 */
  public VDMSet getProducts() {

    /* Transaction.vdmpp 17:3 */
    return Utils.copy(productsTransacted);
  }
  /* Transaction.vdmpp 1:7 */
  public Transaction() {}

  public String toString() {

    return "Transaction{"
        + "value := "
        + Utils.toString(value)
        + ", date := "
        + Utils.toString(date)
        + ", client := "
        + Utils.toString(client)
        + ", productsTransacted := "
        + Utils.toString(productsTransacted)
        + ", storeAuthorizer := "
        + Utils.toString(storeAuthorizer)
        + "}";
  }
}
