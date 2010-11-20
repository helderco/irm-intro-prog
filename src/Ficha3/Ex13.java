
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex13 {

    private static double tolerance = 1E-5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double x;

        Scanner input = new Scanner(System.in);

        System.out.print("x = ");
        x = input.nextDouble();

        System.out.print("Tolerância = ");
        tolerance = input.nextDouble();

        System.out.println();
        System.out.println("sin(x) = " + sin(x));
        System.out.println("Controlo: sin(x) = " + Math.sin(x));
        System.out.println("     dif: " + (Math.sin(x)-sin(x)));
    }

    public static double sin(double x) {
        int n = 1;
        double taylorSum = 0;

        do {
            taylorSum += taylor(x, n++);
        } while (Math.abs(taylor(x, n)) >= tolerance);


        return taylorSum;
    }

    public static double taylor(double x, int n) {
        return Math.pow(-1, n+1)*Math.pow(x, 2*n-1)/fact(2*n-1);
    }

    public static long fact(int num) {
        return (num <= 1) ? 1 : fact(num-1) * num;
    }
}
