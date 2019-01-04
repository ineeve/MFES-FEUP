package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CashierQuote {
  private static int hc = 0;
  private static CashierQuote instance = null;

  public CashierQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CashierQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CashierQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CashierQuote;
  }

  public String toString() {

    return "<Cashier>";
  }
}
