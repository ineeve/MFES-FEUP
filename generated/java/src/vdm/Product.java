package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Product {
  protected static Number idCounter = 0L;
  protected Number id;
  protected Number buyPrice;
  protected Number sellPrice;
  protected Object state;
  protected String description;

  public Number getSellPrice() {

    return sellPrice;
  }

  public Number getBuyPrice() {

    return buyPrice;
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

  public Number getStateValue() {

    if (Utils.equals(state, vdm.quotes.NewQuote.getInstance())) {
      return 1.0;
    }

    if (Utils.equals(state, vdm.quotes.Low_UseQuote.getInstance())) {
      return 0.8;
    }

    return 0.5;
  }

  public Product() {}

  public String toString() {

    return "Product{"
        + "idCounter := "
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
