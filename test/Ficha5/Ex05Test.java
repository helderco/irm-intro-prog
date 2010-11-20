
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex05Test {

    private final int[] entries = {
        10, 40, 50, 34, 55, 31, 27, 14, 20, 22, 30, 33, 38, 5, 4, 3
    };

    private final int[] exits = {
        1, 13, 22, 50, 5, 29, 45, 30, 9, 17, 12, 61, 53, 26, 33, 10
    };

    private final Ex05 park = new Ex05(entries, exits);

    public Ex05Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("## Ex 5 ##");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println();
    }

    @Test
    public void testMostTraffic() {
        assertEquals(12, park.mostTraffic());
    }

    @Test
    public void testMaximumOcuppation() {
        assertEquals(2, park.maximumOccupation());
    }

    @Test
    public void testGrowthIntervals() {
        Ex05Growth[] expResult = {
            new Ex05Growth( 8, 10, 64),
            new Ex05Growth(12, 13, 52),
            new Ex05Growth(16, 18, 34)
        };

        Ex05Growth[] result = park.strictGrowthIntervals();
        System.out.println(park.strictGrowth());

        assertArrayEquals(expResult, result);
    }

}