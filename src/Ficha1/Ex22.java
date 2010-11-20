
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i, num, mult;

        Scanner input = new Scanner(System.in);

        System.out.print("Introduza um número inteiro positivo: ");
        num = Math.abs(input.nextInt());

        mult = num / 10 + 1;

        for (i = mult; i >= 1; i--) {
            System.out.print("*");
        }

        System.out.println();
    }

}
