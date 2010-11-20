
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Qual é o seu nome? ");
        String nome = input.nextLine();

        System.out.print("Qual é o seu sobrenome? ");
        String sobrenome = input.nextLine();

        System.out.println("Olá, " + nome + " " + sobrenome + "!");
    }

}
