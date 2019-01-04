package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Toy extends Product {
  private Number minAge;
  private Number maxAge = null;
  private Object subCategory;

  public void cg_init_Toy_1(
      final Object productState, final Number minAgeInput, final Object subCategoryInput) {

    idCounter = Toy.idCounter.longValue() + 1L;
    id = Toy.idCounter;
    state = productState;
    minAge = minAgeInput;
    subCategory = subCategoryInput;
    setBuyPrice();
    setSellPrice();
  }

  public Toy(final Object productState, final Number minAgeInput, final Object subCategoryInput) {

    cg_init_Toy_1(productState, minAgeInput, subCategoryInput);
  }

  public Toy() {}

  public String toString() {

    return "Toy{"
        + "minAge := "
        + Utils.toString(minAge)
        + ", maxAge := "
        + Utils.toString(maxAge)
        + ", subCategory := "
        + Utils.toString(subCategory)
        + "}";
  }
}
