package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Toy extends Product {
  private Number minAge;
  private Number maxAge = null;
  private String description = null;
  private Object subCategory;

  public void cg_init_Toy_1(final Number minAgeInput, final Object subCategoryInput) {

    minAge = minAgeInput;
    subCategory = subCategoryInput;
  }

  public Toy(final Number minAgeInput, final Object subCategoryInput) {

    cg_init_Toy_1(minAgeInput, subCategoryInput);
  }

  public Toy() {}

  public String toString() {

    return "Toy{"
        + "minAge := "
        + Utils.toString(minAge)
        + ", maxAge := "
        + Utils.toString(maxAge)
        + ", description := "
        + Utils.toString(description)
        + ", subCategory := "
        + Utils.toString(subCategory)
        + "}";
  }
}
