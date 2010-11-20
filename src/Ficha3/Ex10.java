
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num, inv;
        Scanner input = new Scanner(System.in);

        System.out.print("Introduza um número: ");
        num = input.nextInt();
        inv = inverse(num);

        System.out.print("Inverso: " + inv);

        if (num == inv) {
            System.out.print("   << É uma capicua!");
        }

        System.out.println();
    }

    public static int inverse(int num) {
        int inverse = 0, process = num;
        
        while (process > 0) {
            inverse = inverse * 10 + process % 10;
            process /= 10;
        }

        return inverse;
    }
}
