
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int time, s, m, h;
        Scanner input = new Scanner(System.in);

        System.out.print("Tempo (segundos): ");
        time = input.nextInt();

        h = time/3600;
        m = time/60 - h*60;
        s = time%60;

        System.out.println(h + "h " + m + "m " + s + "s");
    }

}
