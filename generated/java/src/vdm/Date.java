package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Date {
  private Number year;
  private Number month;
  private Number day;

  public void cg_init_Date_1(final Number d, final Number m, final Number y) {

    day = d;
    month = m;
    year = y;
    return;
  }

  public Date(final Number d, final Number m, final Number y) {

    cg_init_Date_1(d, m, y);
  }

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
