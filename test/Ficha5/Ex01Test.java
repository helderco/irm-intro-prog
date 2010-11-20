
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex01Test {

    public Ex01Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testReverse() {
        assertArrayEquals(
            new int[] {67, 3, 14, 2, 7, 5, 5, 1},
            Ex01.reverse(new int[] {1, 5, 5, 7, 2, 14, 3, 67})
        );
    }

}