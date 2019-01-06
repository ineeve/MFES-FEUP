package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LegosQuote {
  private static int hc = 0;
  private static LegosQuote instance = null;

  public LegosQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static LegosQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new LegosQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof LegosQuote;
  }

  public String toString() {

    return "<Legos>";
  }
}
