package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TODO2Quote {
  private static int hc = 0;
  private static TODO2Quote instance = null;

  public TODO2Quote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static TODO2Quote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new TODO2Quote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof TODO2Quote;
  }

  public String toString() {

    return "<TODO2>";
  }
}
