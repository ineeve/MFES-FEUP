package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GiftCard {
  private static final VDMSet GiftValues = SetUtil.set(10L, 20L, 40L);
  private static Number idCounter = 0L;
  private Number id;
  private Number value;
  /* GiftCard.vdmpp 12:9 */
  public void cg_init_GiftCard_1(final Number v) {

    /* GiftCard.vdmpp 14:4 */
    idCounter = GiftCard.idCounter.longValue() + 1L;
    /* GiftCard.vdmpp 14:32 */
    id = GiftCard.idCounter;
    /* GiftCard.vdmpp 14:49 */
    value = v;
    /* GiftCard.vdmpp 14:61 */
    return;
  }
  /* GiftCard.vdmpp 12:9 */
  public GiftCard(final Number v) {

    cg_init_GiftCard_1(v);
  }
  /* GiftCard.vdmpp 18:14 */
  public Number getValue() {

    /* GiftCard.vdmpp 20:3 */
    return value;
  }
  /* GiftCard.vdmpp 24:21 */
  public static VDMSet getPossibleValues() {

    /* GiftCard.vdmpp 26:3 */
    return Utils.copy(GiftCard.GiftValues);
  }
  /* GiftCard.vdmpp 1:7 */
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
