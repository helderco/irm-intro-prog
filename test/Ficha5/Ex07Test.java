
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex07Test {

    private final int[][] matA = {{2, -3}, {4, 5}, {6, 0}};
    private final int[][] matB = {{7, 3}, {-2, 7}, {1, -5}};

    private final int[][] matC = {{0, -1, 2}, {4, 11, 2}};
    private final int[][] matD = {{3, -1}, {1, 2}, {6, 1}};

    private final int[][] matE = {{1, 2}, {3, 4}, {5, 6}};

    public Ex07Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testSum() {
        int[][] expResult = {{9, 0}, {2, 12}, {7, -5}};
        int[][] result = Ex07.sum(matA, matB);
        assertArrayEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSumValidatesArguments() {
        Ex07.sum(matA, matC);
    }

    @Test
    public void testMult() {
        int[][] expResult = {{11, 0}, {35, 20}};
        int[][] result = Ex07.mult(matC, matD);
        assertArrayEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testMultValidatesArguments() {
        int[][] A = {{7, 3}, {2, 5}, {6, 9}};
        int[][] B = {{4, 5, 6}, {3, 2, 1}, {4, 4, 6}};
        Ex07.mult(A, B);
    }

    @Test
    public void testTransp() {
        int[][] expResult = {{1, 3, 5}, {2, 4, 6}};
        int[][] result = Ex07.transp(matE);
        assertArrayEquals(expResult, result);
    }
}