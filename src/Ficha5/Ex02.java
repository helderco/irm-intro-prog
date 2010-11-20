
package Ficha5;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Quantos números? ");
        int n = input.nextInt();

        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.printf("n%d: ", i+1);
                list[i] = input.nextInt();
            } while (list[i] < 0 || list[i] >= 100);
        }

        int[] count = count(list);

        for (int j = 0; j < count.length; j++) {
            System.out.printf("[%2d, %2d]: %d\n", j*10, j*10+9, count[j]);
        }
    }

    public static int[] count(int[] a) {
        int[] count = new int[10];
        for (int i = 0; i < a.length; i++) {
            count[a[i]/10]++;
        }
        return count;
    }
}
