
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num, count = 0, sum = 0;
        double avg = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduza uma sequência de números, terminada com 0 (zero)...");
        num = input.nextInt();

        while (num != 0) {
            if (num % 2 == 0) {
                sum += num;
                count++;
            }
            num = input.nextInt();
        }

        if (count != 0) {
            avg = (double) sum / count;
        }

        System.out.println("Média: " + avg);
    }

}
