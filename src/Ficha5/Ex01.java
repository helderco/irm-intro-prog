
package Ficha5;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Quantos números? ");
        int n = input.nextInt();

        int[] list = new int[n];

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("n%d: ", i+1);
            list[i] = input.nextInt();
        }

        int[] reversed = reverse(list);

        Utils.printArray(reversed);
    }

    public static int[] reverse(int[] list) {
        int[] reverse = new int[list.length];
        for (int i = 0, j = list.length-1; i < list.length; i++, j--)
            reverse[i] = list[j];
            
        return reverse;
    }
}
