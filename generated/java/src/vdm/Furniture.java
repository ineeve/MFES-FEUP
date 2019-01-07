package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Furniture extends Product {
  private Object subCategory;

  public void cg_init_Furniture_1(
      final Object productState, final String desc, final Object furnitureCat) {

    idCounter = Furniture.idCounter.longValue() + 1L;
    id = Furniture.idCounter;
    state = productState;
    description = desc;
    subCategory = furnitureCat;
    setPrices();
    return;
  }

  public Furniture(final Object productState, final String desc, final Object furnitureCat) {

    cg_init_Furniture_1(productState, desc, furnitureCat);
  }

  public Furniture() {}

  public String toString() {

    return "Furniture{" + "subCategory := " + Utils.toString(subCategory) + "}";
  }
}
