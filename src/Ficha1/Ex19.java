
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, i, sum = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("N = ");
        n = input.nextInt();

        for (i = 1; i <= Math.abs(n); i++) {
            sum += i;
        }

        System.out.println("Somatório de 1 a " + n + " = " + sum);
    }

}
