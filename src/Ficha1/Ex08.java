
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int duration, hours, minutes;
        int mEh, mEm, mLh, mLm;
        int aEh, aEm, aLh, aLm;

        Scanner input = new Scanner(System.in);

        System.out.print("Hora de entrada de manhã: ");
        mEh = input.nextInt();

        System.out.print("Minutos de entrada de manhã: ");
        mEm = input.nextInt();

        System.out.print("Hora de saída de manhã: ");
        mLh = input.nextInt();

        System.out.print("Minutos de saída de manhã: ");
        mLm = input.nextInt();

        System.out.print("Hora de entrada à tarde: ");
        aEh = input.nextInt();

        System.out.print("Minutos de entrada à tarde: ");
        aEm = input.nextInt();

        System.out.print("Hora de saída à tarde: ");
        aLh = input.nextInt();

        System.out.print("Minutos de saída à tarde: ");
        aLm = input.nextInt();

        duration = (60*mLh+mLm)-(60*mEh+mEm) + (60*aLh+aLm)-(60*aEh+aEm);

        hours = duration / 60;
        minutes = duration % 60;

        System.out.println(hours + "h " + minutes + "m de trabalho.");
    }

}
