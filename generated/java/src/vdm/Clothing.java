package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Clothing extends Product {
  private Number maxAge;
  private Number minAge;
  private Object subCategory;

  public void cg_init_Clothing_1(
      final Object productState,
      final Number minAgeInput,
      final Number maxAgeInput,
      final Object subCategoryInput) {

    idCounter = Clothing.idCounter.longValue() + 1L;
    id = Clothing.idCounter;
    state = productState;
    minAge = minAgeInput;
    maxAge = maxAgeInput;
    subCategory = subCategoryInput;
    setBuyPrice();
    setSellPrice();
    return;
  }

  public Clothing(
      final Object productState,
      final Number minAgeInput,
      final Number maxAgeInput,
      final Object subCategoryInput) {

    cg_init_Clothing_1(productState, minAgeInput, maxAgeInput, subCategoryInput);
  }

  public Clothing() {}

  public String toString() {

    return "Clothing{"
        + "maxAge := "
        + Utils.toString(maxAge)
        + ", minAge := "
        + Utils.toString(minAge)
        + ", subCategory := "
        + Utils.toString(subCategory)
        + "}";
  }
}
