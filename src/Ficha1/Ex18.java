
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex18 {

    public static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char choice;
        int result;

        System.out.print("Alínea? ");
        choice = input.nextLine().toLowerCase().charAt(0);

        switch (choice) {
            case 'a':
                System.out.println("a. n x m");
                result = subA();
                break;

            case 'b':
                System.out.println("b. n / d");
                try {
                    result = subB();
                } catch (ArithmeticException e) {
                    System.out.println("Erro: " + e.getMessage());
                    return;
                }
                break;

            case 'c':
                System.out.println("c. a^n");
                result = subC();
                break;

            default:
                System.out.println("Syntaxe: [a-c]");
                return;
        }

        System.out.println("R: " + result);
    }

    public static int subA() {
        int i, n, m, res = 0;

        System.out.print("n = ");
        n = input.nextInt();

        System.out.print("m = ");
        m = input.nextInt();

        for (i = 0; i < n; i++) {
            res += m;
        }

        return res;
    }

    public static int subB() {
        int n, d, div, res = 0;

        System.out.print("n = ");
        n = input.nextInt();

        System.out.print("d = ");
        d = input.nextInt();

        if (d == 0) {
            throw new ArithmeticException("Divisão por zero");
        }

        div = n;

        while (div >= d) {
            div -= d;
            res++;
        }

        return res;
    }

    public static int subC() {
        int a, n, i, j, prod, res;

        System.out.print("a = ");
        a = input.nextInt();

        System.out.print("n = ");
        n = input.nextInt();

        if (n == 0) {
            return 1;
        }

        res = a;
        for (i = 1; i < n; i++) {
            prod = res;
            for (j = 1; j < a; j++) {
                res += prod;
            }
        }

        return res;
    }
}
