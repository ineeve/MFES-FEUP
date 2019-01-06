package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Gear extends Product {
  private Number maxAge = null;
  private Number minAge;
  private Object subCategory;

  public void cg_init_Gear_1(
      final Object productState,
      final String desc,
      final Number minAgeInput,
      final Number maxAgeInput,
      final Object subCategoryInput) {

    idCounter = Gear.idCounter.longValue() + 1L;
    id = Gear.idCounter;
    state = productState;
    description = desc;
    minAge = minAgeInput;
    maxAge = maxAgeInput;
    subCategory = subCategoryInput;
    setBuyPrice();
    setSellPrice();
    return;
  }

  public Gear(
      final Object productState,
      final String desc,
      final Number minAgeInput,
      final Number maxAgeInput,
      final Object subCategoryInput) {

    cg_init_Gear_1(productState, desc, minAgeInput, maxAgeInput, subCategoryInput);
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
