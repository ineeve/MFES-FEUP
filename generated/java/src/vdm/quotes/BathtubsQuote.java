package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BathtubsQuote {
  private static int hc = 0;
  private static BathtubsQuote instance = null;

  public BathtubsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BathtubsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BathtubsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BathtubsQuote;
  }

  public String toString() {

    return "<Bathtubs>";
  }
}
