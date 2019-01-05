package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BedsQuote {
  private static int hc = 0;
  private static BedsQuote instance = null;

  public BedsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BedsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BedsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BedsQuote;
  }

  public String toString() {

    return "<Beds>";
  }
}
