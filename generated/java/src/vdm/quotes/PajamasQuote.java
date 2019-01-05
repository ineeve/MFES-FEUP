package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PajamasQuote {
  private static int hc = 0;
  private static PajamasQuote instance = null;

  public PajamasQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PajamasQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PajamasQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PajamasQuote;
  }

  public String toString() {

    return "<Pajamas>";
  }
}
