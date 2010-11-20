
package Ficha5;

/**
 *
 * @author heldercorreia
 */
class Ex06 {

    private final int DAYS = 15;
    private double[] seller1;
    private double[] seller2;

    public Ex06(double[] seller1, double[] seller2) {
        if (seller1.length != DAYS || seller2.length != DAYS) {
            throw new IllegalArgumentException(
                "Fontes de dados devem representar " + DAYS +
                " dias de vendas."
            );
        }
        this.seller1 = new double[DAYS];
        this.seller2 = new double[DAYS];
        System.arraycopy(seller1, 0, this.seller1, 0, seller1.length);
        System.arraycopy(seller2, 0, this.seller2, 0, seller2.length);
    }

    int daysSeller1WasLowest() {
        int count = 0;

        for (int i = 0; i < DAYS; i++) {
            if (seller1[i] < seller2[i]) {
                count++;
            }
        }

        return count;
    }

    public double averageSales1() {
        double sum = 0;

        for (int i = 0; i < seller1.length; i++) {
            sum += seller1[i];
        }

        return sum / seller1.length * 1000;
    }

    public double averageSales2() {
        double sum = 0;

        for (int i = 0; i < seller2.length; i++) {
            sum += seller2[i];
        }

        return sum / seller2.length * 1000;
    }

}
