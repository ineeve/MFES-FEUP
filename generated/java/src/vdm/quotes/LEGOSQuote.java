package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LEGOSQuote {
  private static int hc = 0;
  private static LEGOSQuote instance = null;

  public LEGOSQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static LEGOSQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new LEGOSQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof LEGOSQuote;
  }

  public String toString() {

    return "<LEGOS>";
  }
}
