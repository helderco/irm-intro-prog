
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num1, num2;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Máximo divisor comum entre dois números:");
        
        System.out.print("n1 = ");
        num1 = input.nextInt();

        System.out.print("n2 = ");
        num2 = input.nextInt();

        System.out.println("R: " + gcd(num1, num2));
    }

    public static int gcd(int num1, int num2) {
        int lastGcd = 1, maxRange = num1 < num2 ? num1 : num2;

        for (int factor = 2; factor <= maxRange; factor++){
            if (num1 % factor == 0 && num2 % factor == 0) {
                lastGcd = factor;
            }
        }

        return lastGcd;
    }
}
