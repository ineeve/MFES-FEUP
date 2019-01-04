package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Gear extends Product {
  private Number maxAge;
  private Number minAge;
  private Object subcategory;

  public Gear() {}

  public String toString() {

    return "Gear{"
        + "maxAge := "
        + Utils.toString(maxAge)
        + ", minAge := "
        + Utils.toString(minAge)
        + ", subcategory := "
        + Utils.toString(subcategory)
        + "}";
  }
}
