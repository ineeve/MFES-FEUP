package vdm;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClientTest {
  private Client client1 = new Client(new String(new char[] {'R', 'e', 'n', 'a', 't', 'o'}));
  private Client client2 = new Client(new String(new char[] {'J', 'o', 'a', 'o'}));

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testClientId() {

    assertTrue(Utils.equals(client1.getId(), 1L));
    assertTrue(Utils.equals(client2.getId(), 2L));
  }

  public static void main() {

    ClientTest clientTest = new ClientTest();
    clientTest.testClientId();
  }

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
