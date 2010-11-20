
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float height, weight;
        char gender;

        Scanner input = new Scanner(System.in);

        System.out.print("Qual a altura? ");
        height = input.nextFloat();
        input.nextLine();

        System.out.print("Qual o sexo? (m/f) ");
        gender = input.nextLine().toLowerCase().charAt(0);

        switch (gender) {
            case 'm':
                weight = (62.1f * Math.abs(height)) - 44.7f;
                break;

            case 'f':
                weight = (72.7f * Math.abs(height)) - 58f;
                break;

            default:
                System.out.println("Erro: 'm' para masculino ou 'f' para feminino");
                return;
        }

        System.out.println("Peso ideal: " + weight + " Kg");
    }

}
