package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CribsQuote {
  private static int hc = 0;
  private static CribsQuote instance = null;

  public CribsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CribsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CribsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CribsQuote;
  }

  public String toString() {

    return "<Cribs>";
  }
}
