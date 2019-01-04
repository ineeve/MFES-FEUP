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

  public VDMSet getProducts() {

    return Utils.copy(productsTransacted);
  }

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
