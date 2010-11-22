
package EmailServer;

import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class ServerTest {

    private Server server;

    private final Account[] accounts = {
        new Account("username1", "password1"),
        new Account("username2", "password2"),
        new Account("username3", "password3"),
        new Account("username4", "password4")
    };

    public ServerTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Before
    public void setUp() {
        server = new Server();

        for (int i = 0; i < accounts.length; i++) {
            server.addAccount(accounts[i]);
        }
    }

    @After
    public void tearDown() {
        server = null;
    }

    @Test
    public void testAddAccount() {
        int total = server.accountsCount();
        assertEquals(4, total);

        for (int i = 0; i < total; i++) {
            assertEquals(accounts[i], server.getAccount(i));
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNoDupplicateAccounts() {
        server.addAccount(accounts[2]);
    }

    @Test
    public void testCanGetAccountUsingCredentials() {
        Account expected = accounts[0];
        Account actual   = server.getAccount("username1@uac.pt", "password1");
        assertEquals(expected, actual);
        assertNull(server.getAccount("dummy@uac.pt", "dummy"));
    }

    @Test
    public void testSend() {
        Message testMessage = new Message(
            "username1@uac.pt", "username2@uac.pt", "Dummy subject", "Dummy body"
        );
        server.send(testMessage);
        Account receiver = server.getAccount(1);
        assertEquals(testMessage, receiver.readLast());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSendToInvalidAddress() {
        Message testMessage = new Message(
            "username1@uac.pt", "dummy@uac.pt", "Dummy subject", "Dummy body"
        );
        server.send(testMessage);
    }

    @Test
    public void testCannotDeleteNonexistentAccounts() {
        server.delete(-1);
        server.delete(10);
        assertEquals(4, server.accountsCount());
    }

    @Test
    public void testDeleteAccount() {
        server.delete(1);
        assertEquals(3, server.accountsCount());
        assertEquals(accounts[3], server.getAccount(1));
    }

    @Test
    public void testDeleteInnactive() {
        server.getAccount(0).setStatus(false);
        server.getAccount(2).setStatus(false);
        server.deleteInnactive();
        assertEquals(2, server.accountsCount());
        assertEquals(accounts[3], server.getAccount(0));
        assertEquals(accounts[1], server.getAccount(1));
    }

}