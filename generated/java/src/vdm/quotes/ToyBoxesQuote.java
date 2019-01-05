package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ToyBoxesQuote {
  private static int hc = 0;
  private static ToyBoxesQuote instance = null;

  public ToyBoxesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ToyBoxesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ToyBoxesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ToyBoxesQuote;
  }

  public String toString() {

    return "<ToyBoxes>";
  }
}
