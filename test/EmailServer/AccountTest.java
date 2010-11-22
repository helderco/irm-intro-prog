
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
public class AccountTest {

    private Account account;
    private Message[] msgs;
    private final String username = "heldercorreia";
    private final String email    = username + "@uac.pt";
    private final String password = "mys3cr3t";
    private final String from     = "sanet@uac.pt";

    public AccountTest() {
        msgs = new Message[Account.INBOX_CAPACITY];
        for (int i = 0; i < msgs.length; i++) {
            msgs[i] = new Message(
                from, email, "Test subject "+i, "Test body "+i
            );
        }
    }

    private void fillInbox(int quantity) {
        for (int i = 0; i < quantity && i < msgs.length; i++) {
            account.receive(msgs[i]);
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Before
    public void setUp() {
        account = new Account(username, password);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testUsernameIsEmail() {
        assertEquals(email, account.getUsername());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUsernameIsMoreThan8chars() {
        new Account("short__", "dummy");
        String teste = "";
        
    }

    @Test(expected=IllegalArgumentException.class)
    public void testPasswordIsMoreThan8chars() {
        new Account("username", "dummy");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testPasswordIsMoreThan8charsWhenChanging() {
        account.changePassword(password, "dummy");
    }

    @Test
    public void testVerifyCredentials() {
        assertTrue(account.verifyCredentials(email, password));
    }

    @Test
    public void testChangePassword() {
        String newPassword = "myN3wS3cr37";
        assertTrue(account.changePassword(password, newPassword));
        assertTrue(account.verifyCredentials(email, newPassword));
    }

    @Test
    public void testIsActive() {
        assertTrue(account.isActive());
    }

    @Test
    public void testSetStatus() {
        account.setStatus(false);
        assertFalse(account.isActive());
    }

    @Test
    public void hasOneMessageOnAccountCreation() {
        assertEquals(1, account.messageCount());
    }

    @Test
    public void testReceive() {
        fillInbox(4);
        assertEquals(5, account.messageCount());
    }

    @Test
    public void testCanHaveFullInbox() {
        fillInbox(Account.INBOX_CAPACITY-1);
        assertEquals(Account.INBOX_CAPACITY, account.messageCount());
    }

    @Test(expected=UnsupportedOperationException.class)
    public void testCannotReceiveWhenFull() {
        fillInbox(Account.INBOX_CAPACITY);
    }

    @Test
    public void testReadFirst() {
        fillInbox(4);
        Message expected = account.welcomeMessage();
        Message actual   = account.readFirst();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadLast() {
        fillInbox(4);
        Message expected = msgs[3];
        Message actual   = account.readLast();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadNext() {
        fillInbox(4);
        account.readFirst();
        Message expected = msgs[0];
        Message actual   = account.readNext();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadNextWhenThereAreNoNext() {
        fillInbox(4);
        account.readLast();
        assertNull(account.readNext());
    }

    @Test
    public void testReadPrevious() {
        fillInbox(4);
        account.readLast();
        Message expected = msgs[2];
        Message actual   = account.readPrevious();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadPreviousWhenThereAreNoPrevious() {
        assertNull(account.readPrevious());
    }

    @Test
    public void testDeleteFromSpecificPosition() {
        fillInbox(4);
        account.delete(2);
        assertEquals(4, account.messageCount());
        assertEquals(msgs[2], account.getMessage(2));
    }

    @Test
    public void testCannotDeleteFromInvalidPosition() {
        fillInbox(4);
        account.delete(-1);
        account.delete(10);
        assertEquals(5, account.messageCount());
    }

    @Test
    public void testDeleteFromReadPointer() {
        fillInbox(4);
        account.delete();
        assertEquals(msgs[0], account.readFirst());
    }

    @Test
    public void testDeleteFromReadPointerAtMiddlePosition() {
        fillInbox(4);
        account.readLast();
        account.readPrevious();
        account.readPrevious();
        account.delete();
        assertEquals(msgs[2], account.getMessage(account.messageCount()-2));
    }

    private void testEmptyInbox() {
        assertEquals(0, account.messageCount());
        assertNull(account.readFirst());
        assertNull(account.readLast());
    }

    @Test
    public void testDeleteUntilInboxEmpty() {
        account.delete();
        testEmptyInbox();
    }

    @Test
    public void testCanEmptyInbox() {
        fillInbox(4);
        account.emptyInbox();
        testEmptyInbox();
    }

    @Test
    public void testDeleteFromLastPositionWhenInboxFull() {
        account.emptyInbox();
        fillInbox(Account.INBOX_CAPACITY);
        account.readLast();
        account.delete();
        assertEquals(Account.INBOX_CAPACITY-1, account.messageCount());
        assertEquals(msgs[msgs.length-2], account.readLast());
    }
}