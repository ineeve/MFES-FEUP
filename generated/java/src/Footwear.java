
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Footwear extends Product {
  private Number size;
  private Object subcategory;
  /* Footwear.vdmpp 1:7 */
  public Footwear() {}

  public String toString() {

    return "Footwear{"
        + "size := "
        + Utils.toString(size)
        + ", subcategory := "
        + Utils.toString(subcategory)
        + "}";
  }
}
