package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class KITCHENSQuote {
  private static int hc = 0;
  private static KITCHENSQuote instance = null;

  public KITCHENSQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static KITCHENSQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new KITCHENSQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof KITCHENSQuote;
  }

  public String toString() {

    return "<KITCHENS>";
  }
}
