package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class High_UseQuote {
  private static int hc = 0;
  private static High_UseQuote instance = null;

  public High_UseQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static High_UseQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new High_UseQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof High_UseQuote;
  }

  public String toString() {

    return "<High_Use>";
  }
}
