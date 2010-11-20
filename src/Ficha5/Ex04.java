
package Ficha5;

import static TPC.TPC2.*;

/**
 *
 * @author heldercorreia
 */
class Ex04 {

    private int[] consumption;

    public Ex04(int[] cons) {

        if (cons.length != 12) {
            throw new IllegalArgumentException(
                "There must be 12 months worth of data"
            );
        }

        consumption = new int[cons.length];
        System.arraycopy(cons, 0, consumption, 0, cons.length);
    }

    private double cost(int m3) {
        return m3 * echelon(m3);
    }

    private double echelon(int m3) {

        if (m3 < 0)
            throw new IllegalArgumentException("There are no negative volumes");

        if (m3 >= 0 && m3 <= 3)
            return 0.38;

        if (m3 >= 4 && m3 <= 7)
            return 0.43;

        if (m3 >= 8 && m3 <= 15)
            return 0.74;

        if (m3 >= 16 && m3 <= 50)
            return 1.91;

        return 3.09;
    }

    public int[] getConsumption() {
        int[] copy = new int[consumption.length];
        System.arraycopy(consumption, 0, copy, 0, copy.length);
        return copy;
    }

    public double[] monthlyConsumption() {
        double[] months = new double[consumption.length];
        
        for (int i = 0; i < months.length; i++) {
            months[i] = cost(consumption[i]);
        }

        return months;
    }

    public double annualMediaConsumption() {
        return avg(consumption);
    }

    public int[] trimesterConsumption() {
        int sum = 0, triCount = 0;
        int[] trimesters = new int[4];

        for (int i = 0; i < consumption.length; i++) {
            if ((i > 0) && (i % 3 == 0)) {
                trimesters[triCount++] = sum;
                sum = 0;
            }

            sum += consumption[i];
        }

        trimesters[triCount] = sum;

        return trimesters;
    }

    public int biggestConsumptionMonth() {
        return indexOf(max(consumption), consumption)+1;
    }

    public int leastConsumptionMonth() {
        return indexOf(min(consumption), consumption)+1;
    }

    public int biggestConsumptionTrimester() {
        int[] trimesters = trimesterConsumption();
        return indexOf(max(trimesters), trimesters)+1;
    }

    public int biggestIncreaseMonth() {
        int month = 1, increase = 0, maxIncrease = 0;

        for (int i = 1; i < consumption.length; i++) {
            increase = consumption[i]-consumption[i-1];

            if (increase > maxIncrease) {
                maxIncrease = increase;
                month = i+1;
            }
        }

        return month;
    }
}
