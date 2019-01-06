package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Footwear extends Product {
  private Number size;
  private Object subCategory;

  public void cg_init_Footwear_1(
      final Object productState, final Number sizeInput, final Object footwearCat) {

    size = sizeInput;
    state = productState;
    subCategory = footwearCat;
    setBuyPrice();
    setSellPrice();
    return;
  }

  public Footwear(final Object productState, final Number sizeInput, final Object footwearCat) {

    cg_init_Footwear_1(productState, sizeInput, footwearCat);
  }

  public Footwear() {}

  public String toString() {

    return "Footwear{"
        + "size := "
        + Utils.toString(size)
        + ", subCategory := "
        + Utils.toString(subCategory)
        + "}";
  }
}
