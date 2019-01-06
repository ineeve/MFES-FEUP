package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Product {
  public static final Number CREDIT_NOTE_MULTIPLIER = 1.2;
  protected static Number idCounter = 0L;
  protected Number id;
  protected Number buyPrice;
  protected Number sellPrice;
  protected Object state;
  protected String description = null;

  public Number getSellPrice() {

    return sellPrice;
  }

  public Number getBuyPrice() {

    return buyPrice;
  }

  public Number getCreditNotesValue() {

    return buyPrice.doubleValue() * Product.CREDIT_NOTE_MULTIPLIER.doubleValue();
  }

  public void setDescription(final String newDescription) {

    description = newDescription;
  }

  protected void setBuyPrice() {

    buyPrice = 10L * getStateValue().doubleValue();
  }

  protected void setSellPrice() {

    sellPrice = 1.3 * buyPrice.doubleValue();
  }

  public void setSellPrice(final Number newPrice) {

    sellPrice = newPrice;
  }

  public Number getStateValue() {

    if (Utils.equals(state, vdm.quotes.NewQuote.getInstance())) {
      return 1.0;
    }

    if (Utils.equals(state, vdm.quotes.Low_UseQuote.getInstance())) {
      return 0.8;
    }

    return 0.5;
  }

  public String getDescription() {

    return description;
  }

  public Product() {}

  public String toString() {

    return "Product{"
        + "CREDIT_NOTE_MULTIPLIER = "
        + Utils.toString(CREDIT_NOTE_MULTIPLIER)
        + ", idCounter := "
        + Utils.toString(idCounter)
        + ", id := "
        + Utils.toString(id)
        + ", buyPrice := "
        + Utils.toString(buyPrice)
        + ", sellPrice := "
        + Utils.toString(sellPrice)
        + ", state := "
        + Utils.toString(state)
        + ", description := "
        + Utils.toString(description)
        + "}";
  }
}
