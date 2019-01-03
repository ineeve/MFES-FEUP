package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Clothing extends Product {
  private Number maxAge;
  private Number minAge;
  private Object subcategory;
  /* Clothing.vdmpp 1:7 */
  public Clothing() {}

  public String toString() {

    return "Clothing{"
        + "maxAge := "
        + Utils.toString(maxAge)
        + ", minAge := "
        + Utils.toString(minAge)
        + ", subcategory := "
        + Utils.toString(subcategory)
        + "}";
  }
}
