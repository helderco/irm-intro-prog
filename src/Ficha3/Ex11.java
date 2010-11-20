
package Ficha3;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author heldercorreia
 */
public class Ex11 {

    private static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Cálculo da área de um triângulo");
        System.out.println("-------------------------------");
        menu();
    }

    private static void menu() {
        byte option;
        char choice;

        System.out.println("\nQue dados possui?");
        System.out.println("1) Altura e base do triângulo.");
        System.out.println("2) Dois lados e o ângulo entre ambos.");
        System.out.println("3) O triângulo é equilátero e sabe-se a medida do lado.");
        System.out.println("4) O triângulo é rectângulo e são conhecidos apenas um dos lados e a hipotenusa.");

        System.out.print("\n$ ");
        option = input.nextByte();
        System.out.println();

        switch (option) {
            case 1: opt1(); break;
            case 2: opt2(); break;
            case 3: opt3(); break;
            case 4: opt4(); break;
            default:
                System.out.println("Erro: opção inválida.\n");
                menu();
                return;
        }

        input.nextLine();
        System.out.print("\nDeseja fazer novo cálculo? (s/n) ");
        choice = input.nextLine().toLowerCase().charAt(0);

        switch (choice) {
            case 's':
            case 'y':
                menu();
        }
    }

    // Height and base: A = b*h/2
    private static void opt1() {
        double b, h;

        System.out.print("base = ");
        b = input.nextDouble();

        System.out.print("altura = ");
        h = input.nextDouble();

        printArea(b*h/2);
    }

    // Two sides and their angle: A = a*b*sin(α)/2
    private static void opt2() {
        double a, b, angle;

        System.out.print("a = ");
        a = input.nextDouble();

        System.out.print("b = ");
        b = input.nextDouble();

        System.out.print("α = ");
        angle = input.nextDouble();

        printArea(a*b*sin(angle)/2);
    }

    // Heron theorem: A = t^2*sqrt(3)/4
    private static void opt3() {
        double t;

        System.out.print("lado = ");
        t = input.nextDouble();

        printArea(pow(t, 2)*sqrt(3)/4);
    }

    // Pithagoras theorem: c^2 = a^2 + b^2
    private static void opt4() {
        double c, a, b;

        System.out.print("lado = ");
        a = input.nextDouble();

        System.out.print("hip = ");
        c = input.nextDouble();

        b = sqrt(pow(c, 2) - pow(a, 2));
        printArea(a*b/2);
    }

    private static void printArea(double area) {
        System.out.println("Area = " + area);
    }
}
