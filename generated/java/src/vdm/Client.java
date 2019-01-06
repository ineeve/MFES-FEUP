package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Client {
  private static Number idCounter = 0L;
  private Number id;
  private String name;
  private VDMSet boughtProducts = SetUtil.set();
  private VDMSet soldProducts = SetUtil.set();
  private VDMSet boughtGiftCards = SetUtil.set();

  public void cg_init_Client_1(final String nameSeq) {

    name = nameSeq;
    idCounter = Client.idCounter.longValue() + 1L;
    id = Client.idCounter;
    return;
  }

  public Client(final String nameSeq) {

    cg_init_Client_1(nameSeq);
  }

  public void setName(final String newName) {

    name = newName;
  }

  public String getName() {

    return name;
  }

  public Number getId() {

    return id;
  }

  public void buyProduct(final Product product) {

    boughtProducts = SetUtil.union(Utils.copy(boughtProducts), SetUtil.set(product));
  }

  public void sellProduct(final Product product) {

    soldProducts = SetUtil.union(Utils.copy(soldProducts), SetUtil.set(product));
  }

  public void buyGiftCard(final GiftCard giftCard) {

    boughtGiftCards = SetUtil.union(Utils.copy(boughtGiftCards), SetUtil.set(giftCard));
  }

  public VDMSet getProductsSold() {

    return Utils.copy(soldProducts);
  }

  public VDMSet getProductsBought() {

    return Utils.copy(boughtProducts);
  }

  public VDMSet getGiftCardsBought() {

    return Utils.copy(boughtGiftCards);
  }

  public Client() {}

  public String toString() {

    return "Client{"
        + "idCounter := "
        + Utils.toString(idCounter)
        + ", id := "
        + Utils.toString(id)
        + ", name := "
        + Utils.toString(name)
        + ", boughtProducts := "
        + Utils.toString(boughtProducts)
        + ", soldProducts := "
        + Utils.toString(soldProducts)
        + ", boughtGiftCards := "
        + Utils.toString(boughtGiftCards)
        + "}";
  }
}
