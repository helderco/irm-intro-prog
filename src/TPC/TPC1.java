
package TPC;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author heldercorreia
 */
public class TPC1 {

    public static Scanner input = new Scanner(System.in);
    public static final int MAX = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char choice;

        System.out.print("Com arrays? (s/n) ");
        choice = input.nextLine().toLowerCase().charAt(0);

        switch (choice) {
            case 's':
            case 'y': array(); break;
            default : seq();
        }
    }

    public static void draw(int num) {
        System.out.print(num + " ");
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void seq() {
        int n1, n2, n3, n4, n5;

        System.out.println("Introduza 5 números inteiros positivos:");

        n1 = input.nextInt();
        n2 = input.nextInt();
        n3 = input.nextInt();
        n4 = input.nextInt();
        n5 = input.nextInt();

        System.out.println();

        draw(abs(n1));
        draw(abs(n2));
        draw(abs(n3));
        draw(abs(n4));
        draw(abs(n5));
    }

    public static void array() {
        int[] num = new int[MAX];
        
        System.out.println("Introduza " + MAX + " números inteiros positivos:");

        for (int i = 0; i < MAX; i++) {
            num[i] = input.nextInt();
        }

        System.out.println();

        for (int i = 0; i < MAX; i++) {
            draw(abs(num[i]));
        }
    }
}
