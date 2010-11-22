
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
    public void testReverseOnEvenArray() {
        assertArrayEquals(
            new int[] {68, 8, 19, 9},
            Ex01.implosionSum(new int[] {1, 5, 5, 7, 2, 14, 3, 67})
        );
    }

    @Test
    public void testReverseOnOddArray() {
        assertArrayEquals(
            new int[] {68, 8, 19, 9, 6},
            Ex01.implosionSum(new int[] {1, 5, 5, 7, 3, 2, 14, 3, 67})
        );
    }
}