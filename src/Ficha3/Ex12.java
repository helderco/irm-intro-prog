
package Ficha3;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Ex12 {

    private static Scanner input = new Scanner(System.in);
    private static float total = 0;

    public static void main(String[] args) {

        System.out.println("Pronto-a-vestir");
        System.out.println("---------------");
        System.out.println();
        menu();
    }

    private static void menu() {
        byte option;

        System.out.println("1) Roupa de Senhora (30%)");
        System.out.println("2) Roupa de Homem (20%)");
        System.out.println("3) Roupa de Criança (25%)");
        System.out.println("4) Total a pagar");
        System.out.println("5) Sair");

        System.out.print("\n$ ");
        option = input.nextByte();
        System.out.println();

        switch (option) {
            case 1: opt1(); break;
            case 2: opt2(); break;
            case 3: opt3(); break;
            case 4: opt4(); break;
            case 5: return;
            default:
                System.out.println("Erro: opção inválida.\n");
        }

        menu();
    }

    // Roupa de Senhora (30%)
    private static void opt1() {
        System.out.print("Roupa de Senhora: ");
        float x = input.nextFloat();
        x *= 1 - 0.30f;
        total += x;
        report(x);
    }

    // Roupa de Homem (20%)
    private static void opt2() {
        System.out.print("Roupa de Homem: ");
        float x = input.nextFloat();
        x *= 1 - 0.20f;
        total += x;
        report(x);
    }

    // Roupa de Criança (25%)
    private static void opt3() {
        System.out.print("Roupa de Criança: ");
        float x = input.nextFloat();
        x *= 1 - 0.25f;
        total += x;
        report(x);
    }

    // Total a pagar
    private static void opt4() {
        System.out.printf("Total = %.2f euros", total);
        System.out.printf("\n(Prima enter para continuar...)\n");
        input.nextLine();
        input.nextLine();
    }

    private static void report(float x) {
        System.out.println("+ " + x);
        System.out.println();
    }
}
