package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TrolleysQuote {
  private static int hc = 0;
  private static TrolleysQuote instance = null;

  public TrolleysQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static TrolleysQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new TrolleysQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof TrolleysQuote;
  }

  public String toString() {

    return "<Trolleys>";
  }
}
