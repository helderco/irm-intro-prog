
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex05 {
    
    public static final float 
        DISTRIBUITOR = 0.28f,
        TAXES = 0.45f;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float consumer_price, factory_cost;
        Scanner input = new Scanner(System.in);

        System.out.print("Qual o preço de fábrica? ");
        factory_cost = input.nextFloat();

        consumer_price = factory_cost * (1 + DISTRIBUITOR + TAXES);
        System.out.println("Custo ao consumidor: " + consumer_price + " euros");
    }

}
