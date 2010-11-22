
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

        Utils.printArray(implosionSum(list));
    }

    public static int[] implosionSum(int[] list) {
        int[] result = new int[list.length/2+list.length%2];

        for (int j, i = 0; i < result.length; i++) {
            result[i] = list[i]+list[list.length-1-i];
        }

        return result;
    }
}
