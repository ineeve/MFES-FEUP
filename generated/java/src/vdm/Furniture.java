package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Furniture extends Product {
  private Object subcategory;
  /* Furniture.vdmpp 1:7 */
  public Furniture() {}

  public String toString() {

    return "Furniture{" + "subcategory := " + Utils.toString(subcategory) + "}";
  }
}
