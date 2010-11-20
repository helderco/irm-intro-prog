
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, k, ord, space;
        Scanner input = new Scanner(System.in);

        System.out.println("Triângulo de Pascal");
        System.out.print("n = ");
        ord = input.nextInt();

        System.out.println();

        space = Math.max(6, nextEven(ord+1));

        for (n = 0; n <= ord; n++) {
            if (n < ord) {
                System.out.printf("%"+((space/2)*(ord-n))+"s", "");
            }
            for (k = 0; k <= n; k++) {
                System.out.printf("%-"+(space-1)+"d ", comb(n, k));
            }
            System.out.println();
        }
    }

    public static long comb(int n, int k) {
        return fact(n) / (fact(k)*fact(n-k));
    }

    public static long fact(int num) {
        return (num <= 1) ? 1 : fact(num-1) * num;
    }

    public static int nextEven(int num) {
        return num%2==0 ? num : num+1;
    }
}
