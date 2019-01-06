package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Gear extends Product {
  private Number maxAge = null;
  private Number minAge;
  private Object subCategory;

  public void cg_init_Gear_1(
      final Object productState, final Number minAgeInput, final Object subCategoryInput) {

    idCounter = Gear.idCounter.longValue() + 1L;
    id = Gear.idCounter;
    state = productState;
    minAge = minAgeInput;
    subCategory = subCategoryInput;
    setBuyPrice();
    setSellPrice();
    return;
  }

  public Gear(final Object productState, final Number minAgeInput, final Object subCategoryInput) {

    cg_init_Gear_1(productState, minAgeInput, subCategoryInput);
  }

  public Gear() {}

  public String toString() {

    return "Gear{"
        + "maxAge := "
        + Utils.toString(maxAge)
        + ", minAge := "
        + Utils.toString(minAge)
        + ", subCategory := "
        + Utils.toString(subCategory)
        + "}";
  }
}
