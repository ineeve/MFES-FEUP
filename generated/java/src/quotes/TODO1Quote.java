package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TODO1Quote {
  private static int hc = 0;
  private static TODO1Quote instance = null;

  public TODO1Quote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static TODO1Quote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new TODO1Quote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof TODO1Quote;
  }

  public String toString() {

    return "<TODO1>";
  }
}
