
package Ficha1;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte job;
        float salary, new_salary;

        Scanner input = new Scanner(System.in);

        System.out.print("Cargo: ");
        job = input.nextByte();

        System.out.print("Salário: ");
        salary = input.nextFloat();

        System.out.println();

        switch (job) {
            case 101:  // Manager 25%
                new_salary = salary * 1.25f;
                System.out.println("Gerente.");
                break;

            case 102: // Engineer 20%
                new_salary = salary * 1.20f;
                System.out.println("Engenheiro.");
                break;

            case 103: // Technician 15%
                new_salary = salary * 1.15f;
                System.out.println("Técnico.");
                break;

            default: // Other 10%
                new_salary = salary * 1.10f;
        }

        System.out.println("Salário antigo: " + salary);
        System.out.println("Salário novo: " + new_salary);
        System.out.println("Aumento de " + (new_salary - salary) + " euros.");
    }

}
