
package Ficha4;

import java.util.*;


/**
 *
 * @author heldercorreia
 */
public class GerirConta {

    private static Scanner input = new Scanner(System.in);
    private static LinkedHashMap<Long, Conta> contas
             = new LinkedHashMap<Long, Conta>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("======================");
        System.out.println("=  Gestão de contas  =");
        System.out.println("======================");

        menuContas();
    }

    private static void menuContas() {

        Conta conta;

        cabecalho("Menu Principal");
        System.out.println();
        
        System.out.println("1 - Adicionar conta");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Abrir conta");
        System.out.println("4 - Eliminar conta");
        System.out.println("5 - Sair");

        System.out.print("\n$ ");

        int opcao = input.nextInt();

        System.out.println();

        switch (opcao) {
            case 1: 
                conta = criarConta();
                System.out.println("\nRegisto introduzido...\n");
                menuConta(conta);
                break;
            case 2:
                listarContas();
                pausa();
                break;
            case 3:
                cabecalho("Abrir conta");
                conta = seleccionarConta();
                if (conta != null) {
                    menuConta(conta);
                }
                break;
            case 4:
                cabecalho("Eliminar conta");
                conta = seleccionarConta();
                if (conta != null) {
                    if (confirmaEliminarConta(conta)) {
                        try {
                            eliminarConta(conta);
                            System.out.println("Conta eliminada");
                        }
                        catch (NoSuchElementException e) {
                            System.out.println(
                                "Erro inexperado: " + e.getMessage()
                            );
                        }
                        pausa(false);
                    }
                }
                break;
            case 5: return;
            default:
                System.out.println("Erro: opção indisponível.\n");
        }

        menuContas();
    }

    public static void limparInput() {
        if (input.hasNextLine()) {
            input.nextLine();
        }
    }

    public static void pausa(boolean limpar) {
        if (limpar) limparInput();
        System.out.println("\n<Prima ENTER para continuar…>\n");
        input.nextLine();
    }
    public static void pausa() {
        pausa(true);
    }

    public static void cabecalho(String texto) {
        System.out.printf("\n\n:: %s ::\n", texto.toUpperCase());
    }

    private static Conta criarConta() {

        limparInput();

        System.out.print("Nome do titular: ");
        String titular = input.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = input.nextDouble();

        System.out.print("Plafond: ");
        double plafond = input.nextDouble();

        Conta novaConta = new Conta(titular, saldo, plafond);

        contas.put(new Long(novaConta.getNConta()), novaConta);

        return novaConta;
    }

    private static void listarContas() {

        if (!contas.isEmpty()) {
            Map<Long, Conta> contasOrdenadas = new TreeMap<Long, Conta>(contas);
            for (Map.Entry<Long, Conta> entradaConta : contasOrdenadas.entrySet()) {
                Conta conta = entradaConta.getValue();
                System.out.printf("%021d - %s\n",
                    conta.getNConta(),
                    conta.getTitular()
                );
            }
        }
        else {
            System.out.println("Sem registos…");
        }

        System.out.println();
    }

    private static Conta seleccionarConta() {

        System.out.print("Conta número (0 para cancelar): ");
        long nConta = input.nextLong();

        if (nConta == 0) {
            return null;
        }
        
        Long chave = new Long(nConta);

        if (!contas.containsKey(chave)) {
            System.out.println("\nErro: conta inexistente.");
            seleccionarConta();
        }
        
        return contas.get(chave);
    }

    private static boolean confirmaEliminarConta(Conta conta) {

        limparInput();
        
        System.out.printf(
                "\nTem a certeza que deseja eliminar a conta %021d, "
              + "\npertencente ao titular %s? (s/n) ",
              conta.getNConta(), conta.getTitular()
        );
        
        char confirma = input.nextLine().toLowerCase().charAt(0);

        System.out.println();

        switch (confirma) {
            case 's':
            case 'y':
                return true;
        }

        return false;
    }

    private static void eliminarConta(Conta conta) {
        Long chave = new Long(conta.getNConta());
        
        if (!contas.containsKey(chave)) {
            throw new NoSuchElementException("Conta inexistente!");
        }

        contas.remove(chave);
    }

    private static void menuConta(Conta conta) {

        cabecalho("Consulta");

        System.out.println(
                "\nConta: " + conta.getNConta()
              + " - " + conta.getTitular()
        );

        System.out.println();

        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Efectuar depósito");
        System.out.println("3 - Efectuar levantamento");
        System.out.println("4 - Alterar plafond");
        System.out.println("5 - Sair");
        
        System.out.print("\n$ ");

        int opcao = input.nextInt();

        System.out.println();

        switch (opcao) {
            case 1: consultarSaldo(conta); pausa(); break;
            case 2: efectuarDeposito(conta); break;
            case 3: efectuarLevantamento(conta); break;
            case 4: alterarPlafond(conta); break;
            case 5: return;
            default:
                System.out.println("Erro: opção indisponível.\n");
        }
        
        menuConta(conta);
    }

    public static void consultarSaldo(Conta conta) {
        System.out.printf("Saldo contabilístico: €%.2f\n", 
                conta.saldoContabilistico()
        );
        System.out.printf("Saldo disponível: €%.2f\n", 
                conta.saldoDisponivel()
        );
    }

    public static void efectuarDeposito(Conta conta) {
        System.out.print("Valor a depositar: ");
        double valor = input.nextDouble();
        conta.deposito(valor);
    }

    public static void efectuarLevantamento(Conta conta) {
        System.out.print("Valor a levantar: ");
        double valor = input.nextDouble();
        conta.levantamento(valor);
    }

    public static void alterarPlafond(Conta conta) {
        System.out.print("Plafond: ");
        double valor = input.nextDouble();
        conta.setPlafond(valor);
    }
}
