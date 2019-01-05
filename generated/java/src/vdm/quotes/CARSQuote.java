package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CarsQuote {
  private static int hc = 0;
  private static CarsQuote instance = null;

  public CarsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CarsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CarsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CarsQuote;
  }

  public String toString() {

    return "<Cars>";
  }
}
