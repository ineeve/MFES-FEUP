package vdm.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LoggedOutQuote {
  private static int hc = 0;
  private static LoggedOutQuote instance = null;

  public LoggedOutQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static LoggedOutQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new LoggedOutQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof LoggedOutQuote;
  }

  public String toString() {

    return "<LoggedOut>";
  }
}
