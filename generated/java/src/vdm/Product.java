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
  public void cg_init_Product_1(
      final Number buyInput,
      final Number sellInput,
      final Object stateInput,
      final String descriptionInput) {

    /* Product.vdmpp 19:4 */
    idCounter = Product.idCounter.longValue() + 1L;
    /* Product.vdmpp 20:3 */
    id = Product.idCounter;
    /* Product.vdmpp 21:3 */
    buyPrice = buyInput;
    /* Product.vdmpp 22:3 */
    sellPrice = sellInput;
    /* Product.vdmpp 23:3 */
    state = stateInput;
    /* Product.vdmpp 24:3 */
    description = descriptionInput;
  }
  /* Product.vdmpp 17:9 */
  public Product(
      final Number buyInput,
      final Number sellInput,
      final Object stateInput,
      final String descriptionInput) {

    cg_init_Product_1(buyInput, sellInput, stateInput, descriptionInput);
  }
  /* Product.vdmpp 29:14 */
  public Number getSellPrice() {

    /* Product.vdmpp 31:3 */
    return sellPrice;
  }
  /* Product.vdmpp 35:14 */
  public Number getBuyPrice() {

    /* Product.vdmpp 37:3 */
    return buyPrice;
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
