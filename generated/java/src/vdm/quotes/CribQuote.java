package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CribQuote {
  private static int hc = 0;
  private static CribQuote instance = null;

  public CribQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CribQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CribQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CribQuote;
  }

  public String toString() {

    return "<Crib>";
  }
}
