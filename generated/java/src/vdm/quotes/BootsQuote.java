package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BootsQuote {
  private static int hc = 0;
  private static BootsQuote instance = null;

  public BootsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BootsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BootsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BootsQuote;
  }

  public String toString() {

    return "<Boots>";
  }
}
