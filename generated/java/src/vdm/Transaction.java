package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
abstract public class Transaction {
  protected Number value;
  protected Date date;
  protected Client client;
  protected VDMSet productsTransacted = SetUtil.set();
  protected StoreCashier storeAuthorizer;

  public VDMSet getProducts() {

    return Utils.copy(productsTransacted);
  }

  public StoreCashier getCashier() {

    return storeAuthorizer;
  }

  public abstract Number getValue();

  public Number getSumProductValues() {

    return sumProductValues(Utils.copy(productsTransacted));
  }

  protected abstract Number sumProductValues(final VDMSet pSet);

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
