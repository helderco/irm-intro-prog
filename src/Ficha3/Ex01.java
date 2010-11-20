
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduza um número: ");
        even(input.nextInt());
    }

    public static void even(int num) {
        System.out.println(num%2==0?"O número é par.":"O número é ímpar.");
    }
}
