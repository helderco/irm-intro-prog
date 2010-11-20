
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex09 {

    public static final float COST = 20f;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num_cans;
        float price;
        double height, radius, area, liters;

        Scanner input = new Scanner(System.in);

        System.out.print("Altura? ");
        height = input.nextDouble();

        System.out.print("Raio? ");
        radius = input.nextDouble();

        area = Math.PI * Math.pow(radius, 2) + 2*Math.PI * radius * height;
        num_cans = (int) (area/15 + 0.999999);
        price = num_cans * COST;

        System.out.println("São precisas " + num_cans + " latas, custando " + price + " euros.");
    }

}
