
package Ficha1;

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

        float price, material, hours, costperhour;
        Scanner input = new Scanner(System.in);

        System.out.print("Qual o valor da matéria prima? ");
        material = input.nextFloat();

        System.out.print("Qual o número de horas de trabalho? ");
        hours = input.nextFloat();

        System.out.print("Qual o custo horário? ");
        costperhour = input.nextFloat();

        price = 1.6f * (material + hours * costperhour);
        System.out.println("O preço da encomeda é " + price + " euros.");
    }

}
