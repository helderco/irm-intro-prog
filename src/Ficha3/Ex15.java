
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex15 {

    private static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k, day = getDay();

        System.out.print("Translação: ");
        k = input.nextInt();

        System.out.println(getDayString(transDay(day, k)));
    }

    private static int getDay() {
        System.out.print("Dia [2, 3, 4, 5, 6, s , d]: ");
        char day = input.nextLine().toLowerCase().charAt(0);

        switch (day) {
            case '2':
            case '3':
            case '4':
            case '5':
            case '6': return day - '1';
            case 's': return 6;
            case 'd': return 7;
            
            default:
                return getDay();
        }
    }

    private static String getDayString(byte day) {
        switch (day) {
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 : return (day+1) + "ª feira";
            case 6 : return "Sábado";
            case 7 : return "Domingo";
            default: return "¡erro!";
        }
    }

    public static byte transDay(int day, int k) {
        byte newDay = (byte) ((day + k) % 7);
        if (newDay < 0) newDay += 7;
        if (newDay == 0) newDay = 7;
        return newDay;
    }
}
