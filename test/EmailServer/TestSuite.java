
package EmailServer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author heldercorreia
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    EmailServer.ServerTest.class,
    EmailServer.AccountTest.class
})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

}