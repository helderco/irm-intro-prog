
package Ficha1;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author heldercorreia
 */
public class Ex23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num, div;
        boolean prime = true;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Introduza um número inteiro: ");
        num = input.nextInt();

        for (div = 2; div <= abs(num)/2 && num % div == 0; div++) {
            prime = false; break;
        }
        
        System.out.println(prime?"É número primo":"Não é número primo");
    }
}
