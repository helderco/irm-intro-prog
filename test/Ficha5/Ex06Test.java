
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex06Test {

    private final double[] seller1 = {2, 4, 1, 0.4,  3 , 1, 9, 0.3, 3, 1.2, 4.1, 2, 1.2, 3, 2.1};
    private final double[] seller2 = {4, 8, 1,  2 , 3.4, 6, 1, 0.5, 6,  1 , 0.3, 5,  1 , 2, 3.4};

    private final Ex06 store = new Ex06(seller1, seller2);

    public Ex06Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testNumberOfDaysSeller1WasLessThenSeller2() {
        int expResult = 9;
        int result    = store.daysSeller1WasLowest();

        assertTrue(expResult == result);
    }

    @Test
    public void testAverageSales() {
        assertEquals(2486.66666, store.averageSales1(), 1e-5);
        assertEquals(2973.33333, store.averageSales2(), 1e-5);
    }

}