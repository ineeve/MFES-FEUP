package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PuzzlesQuote {
  private static int hc = 0;
  private static PuzzlesQuote instance = null;

  public PuzzlesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PuzzlesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PuzzlesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PuzzlesQuote;
  }

  public String toString() {

    return "<Puzzles>";
  }
}
