package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Date {
  private Number year;
  private Number month;
  private Number day;
  /* Date.vdmpp 15:9 */
  public void cg_init_Date_1(final Number d, final Number m, final Number y) {

    /* Date.vdmpp 18:3 */
    day = d;
    /* Date.vdmpp 19:3 */
    month = m;
    /* Date.vdmpp 20:3 */
    year = y;
    /* Date.vdmpp 21:3 */
    return;
  }
  /* Date.vdmpp 15:9 */
  public Date(final Number d, final Number m, final Number y) {

    cg_init_Date_1(d, m, y);
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
