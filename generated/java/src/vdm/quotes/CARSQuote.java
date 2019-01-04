package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CARSQuote {
  private static int hc = 0;
  private static CARSQuote instance = null;

  public CARSQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CARSQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CARSQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CARSQuote;
  }

  public String toString() {

    return "<CARS>";
  }
}
