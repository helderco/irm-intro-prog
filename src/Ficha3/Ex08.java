
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String phrase;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Qual a frase?");
            phrase = input.nextLine();
            if (phrase.equalsIgnoreCase("stop")) {
                break;
            }
            System.out.printf("%s Tem %d caracteres.\n", phrase, phrase.length());
        }
    }
}
