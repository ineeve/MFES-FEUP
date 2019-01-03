package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Low_UseQuote {
  private static int hc = 0;
  private static Low_UseQuote instance = null;

  public Low_UseQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static Low_UseQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new Low_UseQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof Low_UseQuote;
  }

  public String toString() {

    return "<Low_Use>";
  }
}
