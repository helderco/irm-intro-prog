
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte cod;
        float price;
        String payment_method;

        Scanner input = new Scanner(System.in);

        System.out.print("Qual o preço? ");
        price = input.nextFloat();

        System.out.print("Modo de pagamento? ");
        cod = input.nextByte();

        switch (cod) {
            case 1:
                payment_method = "a pronto em dinheiro ou cheque com";
                price *= 1 - 0.10;
                break;

            case 2:
                payment_method = "a pronto em cartão de crédito com";
                price *= 1 - 0.05;
                break;

            case 3:
                payment_method = "em 2 prestações de";
                price /= 2;
                break;

            case 4:
                payment_method = "em 3 prestações de";
                price /= 3 * 1.10;

            default:
                System.out.println("Erro: código entre 1 a 4 (introduzido o " + cod + ").");
                return;
        }

        System.out.println("Pagamento " + payment_method + " " + price);
    }

}
