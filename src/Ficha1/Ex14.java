
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int age;
        Scanner input = new Scanner(System.in);

        System.out.print("Idade: ");
        age = input.nextInt();

        if (age < 5) {
            System.out.println("Não tem idade suficiente.");
        } else if (age < 10) {
            System.out.println("Infantil.");
        } else if (age < 13) {
            System.out.println("Iniciado.");
        } else if (age < 16) {
            System.out.println("Juvenil.");
        } else if (age < 19) {
            System.out.println("Júnior.");
        } else {
            System.out.println("Sénior");
        }
    }

}
