
package Ficha1;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author heldercorreia
 */
public class Ex13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a, b, c;
        Scanner input = new Scanner(System.in);

        System.out.print("a = ");
        a = input.nextDouble();

        System.out.print("b = ");
        b = input.nextDouble();

        System.out.print("c = ");
        c = input.nextDouble();

        if (abs(b-c) < a && a < b+c) {
            if (a == b && b == c) {
                System.out.println("É um triângulo equilátero.");
            } else if (a == b || a == c || b == c) {
                System.out.println("É um triângulo isósceles.");
            } else {
                System.out.println("É um triângulo escaleno.");
            }
        } else {
            System.out.println("Não é um triângulo.");
        }
    }
}
