
package Ficha1;

import java.util.*;

/**
 *
 * @author heldercorreia
 */
public class Ex16 {

    public static final int YEAR =
        Calendar.getInstance().get(Calendar.YEAR);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int birth, age;

        Scanner input = new Scanner(System.in);

        System.out.print("Ano de nascimento: ");
        birth = input.nextInt();
        age = YEAR - birth;

        if (age < 14) {
            System.out.println("Não tem idade suficiente.");
        } else {
            System.out.println("Com " + age + " anos, já pode tirar licença de:");
            System.out.println("- motociclo até 49cc");
            if (age >= 16) {
                System.out.println("- motociclo até 125cc");
                if (age >= 18) {
                    System.out.println("- moto ou carro");
                    if (age >= 21) {
                        System.out.println("- condução profissional");
                    }
                }
            }
        }
    }
}
