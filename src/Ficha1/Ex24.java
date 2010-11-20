
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        float ammount;

        Scanner input = new Scanner(System.in);

        System.out.print("€ ");
        ammount = input.nextFloat();

        if (ammount >= 500) {
            System.out.println((int)ammount/500 + " notas de 500 euros");
            ammount %= 500;
        }

        if (ammount >= 200) {
            System.out.println((int)ammount/200 + " notas de 200 euros");
            ammount %= 200;
        }

        if (ammount >= 100) {
            System.out.println((int)ammount/100 + " notas de 100 euros");
            ammount %= 100;
        }

        if (ammount >= 50) {
            System.out.println((int)ammount/50 + " notas de 50 euros");
            ammount %= 50;
        }

        if (ammount >= 20) {
            System.out.println((int)ammount/20 + " notas de 20 euros");
            ammount %= 20;
        }

        if (ammount >= 10) {
            System.out.println((int)ammount/10 + " notas de 10 euros");
            ammount %= 10;
        }

        if (ammount >= 5) {
            System.out.println((int)ammount/5 + " notas de 5 euros");
            ammount %= 5;
        }

        if (ammount >= 2) {
            System.out.println((int)ammount/2 + " moedas de 2 euros");
            ammount %= 2;
        }

        if (ammount >= 1) {
            System.out.println((int)ammount + " moedas de 1 euro");
            ammount %= 1;
        }

        ammount = Math.round(ammount*100);

        if (ammount >= 50) {
            System.out.println((int)ammount/50 + " moedas de 50 cêntimos");
            ammount %= 50;
        }

        if (ammount >= 20) {
            System.out.println((int)ammount/20 + " moedas de 20 cêntimos");
            ammount %= 20;
        }

        if (ammount >= 10) {
            System.out.println((int)ammount/10 + " moedas de 10 cêntimos");
            ammount %= 10;
        }

        if (ammount >= 5) {
            System.out.println((int)ammount/5 + " moedas de 5 cêntimos");
            ammount %= 5;
        }

        if (ammount >= 2) {
            System.out.println((int)ammount/2 + " moedas de 2 cêntimos");
            ammount %= 2;
        }

        if (ammount > 0) {
            System.out.println("1 moeda de 1 cêntimo");
        }
    }
}
