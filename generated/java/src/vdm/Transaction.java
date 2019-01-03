package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Transaction {
  protected Number value;
  protected Date date;
  protected Client client;
  protected VDMSet productsTransacted;
  protected StoreCashier storeAuthorizer;
  /* Transaction.vdmpp 18:13 */
  public VDMSet getProducts() {

    throw new UnsupportedOperationException();
  }
  /* Transaction.vdmpp 1:7 */
  public Transaction() {}

  public String toString() {

    return "Transaction{"
        + "value := "
        + Utils.toString(value)
        + ", date := "
        + Utils.toString(date)
        + ", client := "
        + Utils.toString(client)
        + ", productsTransacted := "
        + Utils.toString(productsTransacted)
        + ", storeAuthorizer := "
        + Utils.toString(storeAuthorizer)
        + "}";
  }

  public static class Date implements Record {
    public Number year;
    public Number month;
    public Number day;

    public Date(final Number _year, final Number _month, final Number _day) {

      year = _year;
      month = _month;
      day = _day;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day);
    }

    public Date copy() {

      return new Date(year, month, day);
    }

    public String toString() {

      return "mk_Transaction`Date" + Utils.formatFields(year, month, day);
    }
  }
}
