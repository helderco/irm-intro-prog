
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nmax, num, min, max, count = 0, sum = 0;
        double avg;

        Scanner input = new Scanner(System.in);

        System.out.print("Introduza um máximo de leituras: ");
        nmax = input.nextInt();

        if (nmax < 1) {
            System.out.println("Erro: o número máximo de leituras deve ser maior que 1 (um).");
        }
        
        System.out.println("Introduza uma sequência de números, terminados com 0 (zero)...");
        num = min = max = input.nextInt();

        while (num != 0 && count < nmax) {
            if (num < min) min = num;
            if (num > max) max = num;
            sum += num;
            count++;
            if (count < nmax) {
                num = input.nextInt();
            }
        }

        avg = (double) sum / count;

        System.out.println("Média: " + avg);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
    }

}
