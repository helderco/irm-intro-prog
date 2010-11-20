
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex09Test {

    private final int[][] data = {
        {8, 14,  0,  3, -1},
        {7, 11,  5, 91,  3},
        {8, -4, 19,  5, 57}
    };

    private final Ex09 matop = new Ex09(data);

    public Ex09Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testCopiedData() {
        assertFalse(data == matop.getMatrix());
        assertArrayEquals(data, matop.getMatrix());
    }

    @Test
    public void testSwitchExtremes() {
        int[][] expResult = {
            {8, -1,  0, 3, 14},
            {7, 11,  5, 3, 91},
            {8, 57, 19, 5, -4}
        };
        matop.switchExtremes();
        assertArrayEquals(expResult, matop.getMatrix());
    }

    @Test
    public void testShiftColumnsRight() {
        int[][] expResult = {
            {-1, 8, 14,  0,  3},
            { 3, 7, 11,  5, 91},
            {57, 8, -4, 19,  5}
        };
        matop.shiftColumnsRight();
        assertArrayEquals(expResult, matop.getMatrix());
    }

    @Test
    public void testShiftLinesUp() {
        int[][] expResult = {
            {7, 11,  5, 91,  3},
            {8, -4, 19,  5, 57},
            {8, 14,  0,  3, -1}
        };
        matop.shiftLinesUp();
        assertArrayEquals(expResult, matop.getMatrix());
    }

    @Test
    public void testReplaceColumnsByMinimumSum() {
        int[][] expResult = {
            {14, 14, 14, 14, 14},
            {11, 11, 11, 11, 11},
            {-4, -4, -4, -4, -4}
        };
        matop.replaceColumnsByMinimumSum();
        assertArrayEquals(expResult, matop.getMatrix());
    }

    @Test
    public void testSortMatrix() {
        int testData[][] = {
            {7, 11,  5, 91,  5},
            {8, 14,  0,  3, -1},
            {8, -4, 19,  5, 57},
            {7, 11,  6, 91,  3}
        };

        int[][] expResult = {
            {8, 14,  0,  3, -1},
            {8, -4, 19,  5, 57},
            {7, 11,  6, 91,  3},
            {7, 11,  5, 91,  5}
        };

        Ex09 newop = new Ex09(testData);
        newop.sortMatrix();
        assertArrayEquals(expResult, newop.getMatrix());
    }
}