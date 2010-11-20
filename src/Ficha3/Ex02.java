
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Encontrar números divisores de: ");
        divisors(input.nextInt());
    }

    public static void divisors(int num) {
        System.out.print("R:");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(" " + i);
            }
        }
        System.out.println();
    }
}
