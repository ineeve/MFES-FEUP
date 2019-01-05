package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SwingsQuote {
  private static int hc = 0;
  private static SwingsQuote instance = null;

  public SwingsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SwingsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SwingsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SwingsQuote;
  }

  public String toString() {

    return "<Swings>";
  }
}
