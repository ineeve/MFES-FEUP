package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DressesQuote {
  private static int hc = 0;
  private static DressesQuote instance = null;

  public DressesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DressesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DressesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DressesQuote;
  }

  public String toString() {

    return "<Dresses>";
  }
}
