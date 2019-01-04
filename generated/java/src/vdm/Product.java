package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Product {
  private static Number idCounter = 0L;
  private Number id;
  private Number buyPrice;
  private Number sellPrice;
  private Object state;
  private String description;

  public void cg_init_Product_1(
      final Number buyInput,
      final Number sellInput,
      final Object stateInput,
      final String descriptionInput) {

    idCounter = Product.idCounter.longValue() + 1L;
    id = Product.idCounter;
    buyPrice = buyInput;
    sellPrice = sellInput;
    state = stateInput;
    description = descriptionInput;
  }

  public Product(
      final Number buyInput,
      final Number sellInput,
      final Object stateInput,
      final String descriptionInput) {

    cg_init_Product_1(buyInput, sellInput, stateInput, descriptionInput);
  }

  public Number getSellPrice() {

    return sellPrice;
  }

  public Number getBuyPrice() {

    return buyPrice;
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
