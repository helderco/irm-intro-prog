
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex05 {

    private static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.print("Alínea? [a|b] ");
        char choice = input.nextLine().toLowerCase().charAt(0);

        switch (choice) {
            case 'a': subA(); break;
            case 'b': subB(); break;
            default:
                System.out.print("n: ");
                int n = input.nextInt();
                System.out.println("Fibonacci("+n+") = "+fibonacci(n));
        }
    }

    private static void subA() {
        int n, n2 = 0, n1 = 1, i, tmp;

        System.out.print("n: ");
        n = input.nextInt();

        System.out.print("Sequência Fibonnaci até " + n + ": " + n1);
        for (i = 2; i <= n; i++) {
            tmp = n2 + n1;
            n2 = n1;
            n1 = tmp;
            System.out.print(" " + n1);
        }

        System.out.println();
    }

    private static void subB() {
        int n, fib, i = 0;

        System.out.print("n: ");
        n = input.nextInt();

        if (n == 1) {
            System.out.println("O 1 é um número Fibonacci de ordem 1 ou 2.");
        }

        else {
            do {
                fib = fibonacci(++i);
                if (fib == n) {
                    System.out.println("O " + n + " é um número Fibonacci de ordem " + i + ".");
                    return;
                }
            } while (fib <= n);
        }

        System.out.println(n + " não é um número Fibonacci.");
    }

    public static int fibonacci(int num) {
        return num < 3 ? 1 : fibonacci(num-2) + fibonacci(num-1);
    }
}
