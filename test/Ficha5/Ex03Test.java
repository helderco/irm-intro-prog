
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex03Test {

    public Ex03Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testShortDuplicateSortedMerge() {
        int[] a = {1, 4, 5, 8};
        int[] b = {2, 4, 5, 18};
        int[] expResult = {1, 2, 4, 5, 8, 18};
        int[] result = Ex03.sortedMerge(a, b);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testShortSortedMerge() {
        int[] a = {1, 4, 5, 8};
        int[] b = {2, 6, 13, 18};
        int[] expResult = {1, 2, 4, 5, 6, 8, 13, 18};
        int[] result = Ex03.sortedMerge(a, b);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testSortedMerge() {
        int[] a = {1, 4, 5, 8, 13, 35, 64, 72, 76};
        int[] b = {2, 6, 13, 18, 33, 45, 76, 88, 92};
        int[] expResult = {1, 2, 4, 5, 6, 8, 13, 18, 33, 35, 45, 64, 72, 76, 88, 92};
        int[] result = Ex03.sortedMerge(a, b);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testSortedMergeWithDifferentLengths() {
        int[] a = {1, 4, 5, 8, 13, 35, 64, 72, 76};
        int[] b = {2, 6, 13, 18, 33, 45, 76, 88};
        int[] expResult = {1, 2, 4, 5, 6, 8, 13, 18, 33, 35, 45, 64, 72, 76, 88};
        int[] result = Ex03.sortedMerge(a, b);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testArrayslice() {
        int[] a = {1, 4, 5, 8, 13, 35, 64, 72};
        int[] expResult = {64, 72};
        int[] result = Ex03.arrayslice(a, 6, 2);
        assertArrayEquals(expResult, result);
    }
}