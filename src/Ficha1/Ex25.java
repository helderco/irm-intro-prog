
package Ficha1;

/**
 *
 * @author heldercorreia
 */
public class Ex25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MAX = 200;
        int months = 0, bunnies = 2;

        for (int i = 1; bunnies < MAX; i++) {
            months += 3;
            bunnies *= 2;
        }

        System.out.println(months + " meses até ao lotamento (" + bunnies + " coelhos)");
    }

}
