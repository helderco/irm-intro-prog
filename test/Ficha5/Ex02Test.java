
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex02Test {

    public Ex02Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testCount() {
        int[] a = {1, 5, 30, 55, 99, 93, 56, 22, 21, 15, 40, 72, 33, 43, 48};
        int[] expResult = {2, 1, 2, 2, 3, 2, 0, 1, 0, 2};
        int[] result = Ex02.count(a);
        assertEquals(Utils.sumArray(expResult), a.length);
        assertArrayEquals(expResult, result);
    }

}