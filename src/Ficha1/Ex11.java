
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                final int NUM_GRADES = 4;
        float sum = 0, avg, grade;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < NUM_GRADES; i++) {
            do {
                System.out.print(i+1 + "ª nota: ");
                grade = input.nextFloat();
            } while (grade < 0 || grade > 20);

            sum += grade;
        }

        avg = sum / NUM_GRADES;
        System.out.println("Média: " + avg + " valores.");
        System.out.println("O aluno está " + (avg >= 9.5 ? "aprovado" : "reprovado") + ".");
    }

}
