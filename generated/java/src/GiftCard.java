
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GiftCard {
  public static final VDMSet GiftValues = SetUtil.set(10L, 20L, 40L);
  private static Number idCounter = 0L;
  private Number id;
  private Number value;
  /* GiftCard.vdmpp 12:9 */
  public GiftCard(final Number v) {

    throw new UnsupportedOperationException();
  }
  /* GiftCard.vdmpp 17:14 */
  public Number getValue() {

    throw new UnsupportedOperationException();
  }
  /* GiftCard.vdmpp 22:21 */
  public static VDMSet getPossibleValues() {

    throw new UnsupportedOperationException();
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
