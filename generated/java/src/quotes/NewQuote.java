package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NewQuote {
  private static int hc = 0;
  private static NewQuote instance = null;

  public NewQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static NewQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new NewQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof NewQuote;
  }

  public String toString() {

    return "<New>";
  }
}
