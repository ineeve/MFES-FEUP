package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GiftCard {
  private static final VDMSet GiftValues = SetUtil.set(10L, 20L, 40L);
  private static Number idCounter = 0L;
  private Number id;
  private Number value;

  public void cg_init_GiftCard_1(final Number v) {

    idCounter = GiftCard.idCounter.longValue() + 1L;
    id = GiftCard.idCounter;
    value = v;
    return;
  }

  public GiftCard(final Number v) {

    cg_init_GiftCard_1(v);
  }

  public Number getValue() {

    return value;
  }

  public static VDMSet getPossibleValues() {

    return Utils.copy(GiftCard.GiftValues);
  }

  public GiftCard() {}

  public String toString() {

    return "GiftCard{"
        + "GiftValues = "
        + Utils.toString(GiftValues)
        + ", idCounter := "
        + Utils.toString(idCounter)
        + ", id := "
        + Utils.toString(id)
        + ", value := "
        + Utils.toString(value)
        + "}";
  }
}
