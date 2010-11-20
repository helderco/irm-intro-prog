
package Ficha5;

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
    Ficha5.Ex01Test.class,
    Ficha5.Ex02Test.class,
    Ficha5.Ex03Test.class,
    Ficha5.Ex04Test.class,
    Ficha5.Ex05Test.class,
    Ficha5.Ex06Test.class,
    Ficha5.Ex07Test.class,
    Ficha5.Ex09Test.class
})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("====== FICHA 5 ======");
        System.out.println();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println();
    }

}