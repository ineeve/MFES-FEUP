package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClientTest {
  private Client client1 = new Client(new String(new char[] {'R', 'e', 'n', 'a', 't', 'o'}));
  private Client client2 = new Client(new String(new char[] {'J', 'o', 'a', 'o'}));
  /* ClientTest.vdmpp 8:10 */
  private void assertTrue(final Boolean cond) {

    /* ClientTest.vdmpp 9:23 */
    return;
  }
  /* ClientTest.vdmpp 12:10 */
  private void testClientId() {

    throw new UnsupportedOperationException();
  }
  /* ClientTest.vdmpp 18:10 */
  private void testGiftCards() {

    throw new UnsupportedOperationException();
  }
  /* ClientTest.vdmpp 23:16 */
  public static void main() {

    /* ClientTest.vdmpp 26:8 */
    ClientTest clientTest = new ClientTest();
    /* ClientTest.vdmpp 27:4 */
    clientTest.testClientId();
    /* ClientTest.vdmpp 28:4 */
    clientTest.testGiftCards();
  }
  /* ClientTest.vdmpp 1:7 */
  public ClientTest() {}

  public String toString() {

    return "ClientTest{"
        + "client1 := "
        + Utils.toString(client1)
        + ", client2 := "
        + Utils.toString(client2)
        + "}";
  }
}
