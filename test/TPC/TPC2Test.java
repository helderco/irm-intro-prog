
package TPC;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class TPC2Test {

    @Test
    public void testFind() {
        System.out.println("* find(int, int[])");
        assertTrue(TPC2.find(3, new int[] {1, 4, 3, 5, 6}));
        assertFalse(TPC2.find(3, new int[] {1, 4, 5, 6}));
    }

    @Test
    public void testIndexOf() {
        System.out.println("* indexOf(int, int[])");
        int[] haystack = {-4, 3, 6, 10, 12};
        assertEquals(2, TPC2.indexOf(6, haystack));
        assertEquals(4, TPC2.indexOf(12, haystack));
        assertEquals(-1, TPC2.indexOf(8, haystack));
    }

    @Test
    public void testMax() {
        System.out.println("* max(int[])");
        assertEquals(12, TPC2.max(new int[] {1, 4, 6, 8, 10, 12, 3, -5}));
        assertEquals(-1, TPC2.max(new int[] {-1, -4, -6, -8, -5}));
    }

    @Test
    public void testMin() {
        System.out.println("* min(int[])");
        assertEquals(-5, TPC2.min(new int[] {1, 4, 6, 8, 10, 12, 3, -5}));
        assertEquals(4, TPC2.min(new int[] {10, 4, 6, 8, 5}));
    }

    @Test
    public void testSum() {
        System.out.println("* sum(int[])");
        assertEquals(77, TPC2.sum(new int[] {4, 6, 12, 40, 3, -5, 17}));
        assertEquals(71, TPC2.sum(new int[] {5, 13, 6, 50, -12, 4, 5}));
    }

    @Test
    public void testProd() {
        System.out.println("* prod(int[])");
        assertEquals(22680, TPC2.prod(new int[] {1, 5, 7, 3, -4, -6, 9}));
        assertEquals(-22680, TPC2.prod(new int[] {1, 5, 7, 3, -4, 6, 9}));
        assertEquals(0, TPC2.prod(new int[] {1, 5, 0, 3, -4, 6, 9}));
    }

    @Test
    public void testAvg() {
        System.out.println("* avg(int[])");
        assertEquals(12.666666, TPC2.avg(new int[] {13, 15, 6, 7, 17, 18}), 0.00001);
        assertEquals(7.833333, TPC2.avg(new int[] {13, 15, 6, 12, 0, 1}), 0.00001);
        assertEquals(-4.833333, TPC2.avg(new int[] {-5, -65, 0, 0, 17, 24}), 0.00001);
    }

    @Test
    public void testMode() {
        assertArrayEquals(new int[] {4}, TPC2.mode(new int[] {-13, 4, 90, 4, 5, 56, 4}));
    }

    @Test
    public void testBimodal() {
        assertArrayEquals(new int[] {4, 5}, TPC2.mode(new int[] {6, 4, 8, 4, 5, 9, 5}));
    }

    @Test
    public void testNoMode() {
        assertArrayEquals(new int[] {}, TPC2.mode(new int[] {6, 3, 0, 2, -6, 8}));
    }

    @Test
    public void testVar() {
        System.out.println("* var(int[])");
        assertEquals(2.9, TPC2.var(new int[] {1, 2, 3, 4, 5, 6}), 0.1);
    }
}