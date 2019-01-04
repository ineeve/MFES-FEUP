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

    /* ClientTest.vdmpp 15:3 */
    assertTrue(Utils.equals(client1.getId(), 1L));
    /* ClientTest.vdmpp 16:3 */
    assertTrue(Utils.equals(client2.getId(), 2L));
  }
  /* ClientTest.vdmpp 20:16 */
  public static void main() {

    /* ClientTest.vdmpp 23:8 */
    ClientTest clientTest = new ClientTest();
    /* ClientTest.vdmpp 24:4 */
    clientTest.testClientId();
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
