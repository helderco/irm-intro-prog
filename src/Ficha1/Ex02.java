
package Ficha1;

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
        System.out.print("Introduza o seu nome: ");
        String nome = input.nextLine();
        System.out.println("Olá, " + nome + "!");
    }

}
