
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("String: ");
        String haystack = input.nextLine();

        System.out.print("Carácter: ");
        char needle = input.nextLine().charAt(0);

        System.out.println("`"+needle+"` encontra-se "+charcount(needle, haystack) + " vezes na string dada.");
    }

    public static int charcount(char needle, String haystack) {
        int i, sum = 0;

        for (i = 0; i < haystack.length(); i++) {
            if (needle == haystack.charAt(i)) {
                sum++;
            }
        }

        return sum;
    }
}
