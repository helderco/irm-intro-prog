
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex06 {

    public static final float
        CONSHIGH = 8.0f,
        CONSCITY = CONSHIGH * 1.15f;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float capacity, distHigh, distCity;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Quantos litros no tanque? ");
            capacity = input.nextFloat();
        } while(capacity < 0 || capacity > 40);

        distHigh = capacity * 100 / CONSHIGH;
        distCity = capacity * 100 / CONSCITY;

        System.out.println("Distância na circulação em autoestrada: " + distHigh + " Km");
        System.out.println("Distância na circulação citadina: " + distCity + " Km");
    }

}
