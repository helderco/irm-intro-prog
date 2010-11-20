
package Ficha2;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author heldercorreia
 */
public class Ex7 {

    private static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char choice;

        System.out.print("Alínea? ");
        choice = input.nextLine().toLowerCase().charAt(0);

        switch (choice) {
            case 'a': subA(); break;
            case 'b': subB(); break;
            case 'c': subC(); break;
            case 'd': subD(); break;
            case 'e': subE(); break;
            case 'f': subF(); break;
            case 'g': subG(); break;
            default:
                System.out.println("Escolha: [a-g]");
        }
    }

    public static void subA() {
        int x, y;

        System.out.println("a. y(x + 2)");

        System.out.print("x = ");
        x = input.nextInt();

        System.out.print("y = ");
        y = input.nextInt();

        System.out.println("R: " + (y * (x + 2)));
    }

    public static void subB() {
        int a, b;

        System.out.println("b. (a + b)^2");

        System.out.print("a = ");
        a = input.nextInt();

        System.out.print("b = ");
        b = input.nextInt();

        System.out.println("R: " + pow(a+b, 2));
    }

    public static void subC() {
        int x, y, result;

        System.out.println("c. |x - y| - 3x + 2");

        System.out.print("x = ");
        x = input.nextInt();

        System.out.print("y = ");
        y = input.nextInt();

        System.out.println("R: " + (abs(x-y) - 3*x + 2));
    }

    public static void subD() {
        int x, y;

        System.out.println("d. sqrt(|x+1|^2/(x+1)^2)");

        System.out.print("x = ");
        x = input.nextInt();

        System.out.print("y = ");
        y = input.nextInt();

        System.out.println("R: " + sqrt(pow(abs(x+1), 2)/pow(x+1, 2)));
    }

    public static void subE() {
        int a, b;

        System.out.println("e. (a + |b / (b - a)|)^2");

        System.out.print("a = ");
        a = input.nextInt();

        System.out.print("b = ");
        b = input.nextInt();

        System.out.println("R: " + pow(a + abs(b / (b - a)), 2));
    }

    public static void subF() {
        int a, b;

        System.out.println("f. |(a+b)/(a-b) (a^2 + b^2)|");

        System.out.print("a = ");
        a = input.nextInt();

        System.out.print("b = ");
        b = input.nextInt();

        System.out.println("R: " + abs((a+b)/(a-b)*(pow(a, 2) + pow(b, 2))));
    }

    public static void subG() {
        int x, y;

        System.out.println("g. (x + y)^3");

        System.out.print("x = ");
        x = input.nextInt();

        System.out.print("y = ");
        y = input.nextInt();

        System.out.println("R: " + pow(x+y, 3));
    }
}
