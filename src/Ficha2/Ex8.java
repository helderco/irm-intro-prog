
package Ficha2;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author heldercorreia
 */
public class Ex8 {

    public static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char choice;

        System.out.print("Alínea? ");
        choice = input.nextLine().toLowerCase().charAt(0);

        switch (choice) {
            case 'a':
                System.out.println("a. y^3(x + 2) - x/5");
                System.out.println("R: " + subA());
                break;

            case 'b':
                System.out.println("b. (a + b)^2 / x^(1/2)");
                System.out.println("R: " + subB());
                break;

            case 'c': 
                System.out.println("c. e^cos(x)");
                System.out.println("R: " + subC());
                break;

            case 'd':
                System.out.println("d. |x - y| - 3x + 2)");
                System.out.println("R: " + subD());
                break;

            case 'e':
                System.out.println("e. (x+1)^(3/2) / |e^(2x-4)+ln(2/(x-1))|");
                System.out.println("R: " + subE());
                break;

            case 'f':
                System.out.println("f. ln((1+sqrt(sin(x)))/(1-sqrt(cos(x))))+2atan(sqrt((x+2)^3)");
                System.out.println("R: " + subF());
                break;
                
            default:
                System.out.println("Syntaxe: [a-f]");
        }
    }

    public static double subA() {
        double x, y;

        System.out.print("x = ");
        x = input.nextDouble();

        System.out.print("y = ");
        y = input.nextDouble();

        return Math.pow(y, 3)*(x + 2) - x/5;
    }

    public static double subB() {
        double a, b, x;

        System.out.print("a = ");
        a = input.nextDouble();

        System.out.print("b = ");
        b = input.nextDouble();

        System.out.print("x = ");
        x = input.nextDouble();

        return pow(a+b, 2) / pow(x, 1/2);
    }

    public static double subC() {
        double x;

        System.out.print("x = ");
        x = input.nextDouble();

        return pow(E, cos(x));
    }

    public static double subD() {
        double x, y;

        System.out.print("x = ");
        x = input.nextDouble();

        System.out.print("y = ");
        y = input.nextDouble();

        return abs(x-y) - 3*x + 2;
    }

    public static double subE() {
        double x;

        System.out.print("x = ");
        x = input.nextDouble();

        return pow(x+1, 1.5) / abs(exp(2*x-4) + log(2/(x-1)));
    }

    public static double subF() {
        double x;

        System.out.print("x = ");
        x = input.nextInt();
        
        return log((1+sqrt(sin(x)))/(1-sqrt(cos(x)))) + 2*atan(sqrt(pow(x+2, 3)));
    }
}
