
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("String: ");
        String haystack = input.nextLine();

        System.out.print("Carácter: ");
        char needle = input.nextLine().charAt(0);

        System.out.print("`"+needle+"` ");
        System.out.print(substr(needle, haystack)?"encontra-se":"não se encontra");
        System.out.println(" na string dada.");
    }

    public static boolean substr(char needle, String haystack) {
        return haystack.indexOf(needle) >= 0;
    }
}
