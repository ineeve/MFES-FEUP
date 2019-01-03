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
  /* Product.vdmpp 17:9 */
  public Product(
      final Number buyInput,
      final Number sellInput,
      final Object stateInput,
      final String descriptionInput) {

    throw new UnsupportedOperationException();
  }
  /* Product.vdmpp 28:14 */
  public Number getSellPrice() {

    throw new UnsupportedOperationException();
  }
  /* Product.vdmpp 33:14 */
  public Number getBuyPrice() {

    throw new UnsupportedOperationException();
  }
  /* Product.vdmpp 1:7 */
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
