package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Date {
  private Number year;
  private Number month;
  private Number day;
  /* Date.vdmpp 15:8 */
  public Date(final Number d, final Number m, final Number y) {

    throw new UnsupportedOperationException();
  }
  /* Date.vdmpp 1:7 */
  public Date() {}

  public String toString() {

    return "Date{"
        + "year := "
        + Utils.toString(year)
        + ", month := "
        + Utils.toString(month)
        + ", day := "
        + Utils.toString(day)
        + "}";
  }
}
