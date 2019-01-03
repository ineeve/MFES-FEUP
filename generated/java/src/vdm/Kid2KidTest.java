package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Kid2KidTest {
  private Kid2Kid kid2kid = new Kid2Kid();
  /* Kid2KidTest.vdmpp 6:10 */
  private void assertTrue(final Boolean cond) {

    /* Kid2KidTest.vdmpp 7:23 */
    return;
  }
  /* Kid2KidTest.vdmpp 10:10 */
  private void testAddClient() {

    /* Kid2KidTest.vdmpp 13:4 */
    assertTrue(Utils.equals(kid2kid.getClients().size(), 0L));
    /* Kid2KidTest.vdmpp 14:4 */
    kid2kid.addClient(new Client("abc"));
    /* Kid2KidTest.vdmpp 15:4 */
    assertTrue(Utils.equals(kid2kid.getClients().size(), 1L));
  }
  /* Kid2KidTest.vdmpp 18:10 */
  private void testAddStore() {

    /* Kid2KidTest.vdmpp 21:4 */
    assertTrue(Utils.equals(kid2kid.getStores().size(), 0L));
    /* Kid2KidTest.vdmpp 22:4 */
    kid2kid.addStore(new Store("Porto"));
    /* Kid2KidTest.vdmpp 23:4 */
    assertTrue(Utils.equals(kid2kid.getStores().size(), 1L));
  }
  /* Kid2KidTest.vdmpp 26:16 */
  public static void main() {

    /* Kid2KidTest.vdmpp 29:8 */
    new Kid2KidTest().testAddClient();
    /* Kid2KidTest.vdmpp 30:8 */
    new Kid2KidTest().testAddStore();
  }
  /* Kid2KidTest.vdmpp 1:7 */
  public Kid2KidTest() {}

  public String toString() {

    return "Kid2KidTest{" + "kid2kid := " + Utils.toString(kid2kid) + "}";
  }
}
