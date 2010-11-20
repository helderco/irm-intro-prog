
package Ficha5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heldercorreia
 */
public class Ex04Test {

    private final double precision = 0.01;
    private final int[] consumption = {30, 43, 31, 14, 18, 28, 39, 62, 51, 33, 29, 22};
    private final Ex04 client = new Ex04(consumption);

    public Ex04Test() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Test
    public void testConstructor() {
        assertArrayEquals(consumption, client.getConsumption());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInvalidSourceData() {
        new Ex04(new int[] {4, 5, 40, 50});
    }

    @Test
    public void testConsumptionNotPassedByReference() {
        assertFalse(consumption == client.getConsumption());
    }

    @Test
    public void testMonthlyConsumption() {
        double[] expResult = {57.3, 82.13, 59.21, 10.36, 34.38, 53.48, 74.49, 191.58, 157.59, 63.03, 55.39, 42.02};
        double[] result = client.monthlyConsumption();
        assertArrayEquals(expResult, result, precision);
    }

    @Test
    public void testAnnualMedianConsumption() {
        double expResult = 33.3333;
        double result = client.annualMediaConsumption();
        assertEquals(expResult, result, precision);
    }

    @Test
    public void testBiggestConsumptionMonth() {
        assertEquals(8, client.biggestConsumptionMonth());
    }

    @Test
    public void testLeastConsumptionMonth() {
        assertEquals(4, client.leastConsumptionMonth());
    }

    @Test
    public void testTrimesterConsumption() {
        int[] expResult = {104, 60, 152, 84};
        int[] result = client.trimesterConsumption();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testBiggestConsumptionTrimester() {
        assertEquals(3, client.biggestConsumptionTrimester());
    }

    @Test
    public void testBiggestIncreaseMonth() {
        assertEquals(8, client.biggestIncreaseMonth());
    }
}