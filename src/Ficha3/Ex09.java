
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        short key;
        String orig, enc, dec;
        Scanner input = new Scanner(System.in);

        System.out.print("Chave: ");
        key = input.nextShort();

        while (!(key > 0 && key < 256)) {
            System.out.print("Chave [1, 255]: ");
            key = input.nextShort();
        }

        input.nextLine();

        System.out.print("String: ");
        orig = input.nextLine();

        enc = encryptString(orig, key);
        dec = decryptString(enc, key);

        System.out.printf("Enc: %s\nDec: %s\n", enc, dec);
    }

    public static String encryptString(String orig, short key) {
        String process = "";
        for (int i = 0; i < orig.length(); i++) {
            process += (char) ((int) orig.charAt(i) * key);
        }
        return process;
    }

    public static String decryptString(String enc, short key) {
        String process = "";
        for (int i = 0; i < enc.length(); i++) {
            process += (char) ((int) enc.charAt(i) / key);
        }
        return process;
    }
}
