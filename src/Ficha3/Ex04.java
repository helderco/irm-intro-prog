
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            sum += fact(i);
        }

        System.out.println("1∑"+n+" n! = " + sum);
    }

    public static int fact(int num) {
        return (num <= 1) ? 1 : fact(num-1) * num;
    }
}
