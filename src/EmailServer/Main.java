
package EmailServer;

import java.util.Scanner;

/**
 *
 * @author heldercorreia
 */
public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Server server = new Server();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Serviço de email UAç");
        System.out.println("--------------------");
        System.out.println();

        generateAccounts();
        userMenu(login());
    }

    private static void generateAccounts() {
        server.addAccount(new Account("username1", "password1"));
        server.addAccount(new Account("username2", "password2"));
        server.addAccount(new Account("username3", "password3"));
    }

    public static Account login() {
        Account account;
        
        askInput("Username: ");
        String username = input.nextLine();

        if (username.isEmpty()) {
            printNewLine();
            printStatusMessage("Obrigado por usar os nossos serviços!");
            System.exit(0);
        }

        askInput("Password: ");
        String password = input.nextLine();

        account = server.getAccount(username, password);
        printNewLine();

        if (account == null) {
            printErrorMessage("Login inválido!");
            return login();
        }

        return account;
    }

    public static void userMenu(Account account) {

        System.out.println("1. Nova mensagem");
        System.out.println("2. Ler recebidas ("+account.messageCount()+")");
        System.out.println("3. Terminar");

        askInput("\n> ");

        switch (getOption()) {
            case 1:
                try {
                    server.send(newMessage(account));
                    printStatusMessage("Mensagem enviada com sucesso.");
                } catch (Exception e) {
                    printErrorMessage(e.getMessage());
                }
                break;

            case 2:
                listMessages(account);
                break;

            case 3:
                printStatusMessage("A efectuar o logout…");
                System.out.println("Prima <Enter> para sair…");
                printNewLine();
                userMenu(login());
                return;

            default:
                printErrorMessage("Opção inválida");
        }

        printNewLine();
        userMenu(account);
    }

    public static Message newMessage(Account account) {

        printStatusMessage("Nova mensagem…");

        askInput("Para: ");
        String to = input.nextLine();

        askInput("Assunto: ");
        String subject = input.nextLine();

        askInput("Body: ");
        String body = input.nextLine();

        return account.composeMessage(to, subject, body);
    }

    public static void listMessages(Account account) {
        if (account.messageCount() == 0) {
            printErrorMessage("Sem mensagens para ler");
            return;
        }

        System.out.println("---------------------------------------------");
        System.out.println("Tem " + account.messageCount() + " mensagens.");
        System.out.println();

        System.out.println(Message.listHeader());

        for (int i = 0; i < account.messageCount(); i++) {
            System.out.println(account.getMessage(i).toHeaderString(i+1));
        }
        System.out.println("---------------------------------------------");

        printNewLine();
        listMenu(account);
    }

    private static void listMenu(Account account) {
        askInput("Ler [P]rimeira    [L]er número\n"
               + "Ler [U]ltima      [E]liminar número    [S]air\n> ");
        char oper = input.nextLine().toLowerCase().charAt(0);

        Message msg;

        switch(oper) {
            case 'p':
                msg = account.readFirst();
                readMessage(account, msg);
                break;

            case 'u':
                msg = account.readLast();
                readMessage(account, msg);
                break;
                
            case 'l':
                msg = selectMessage(account);
                readMessage(account, msg);
                break;

            case 'e':
                msg = selectMessage(account);
                account.delete();
                break;

            case 's':
                return;

            default:
                printErrorMessage("Opção inválida!");
        }

        printNewLine();
        listMessages(account);
    }

    public static Message selectMessage(Account account) {
        askInput("Mensagem nº:\n> ");
        short msgnr = getOption();

        Message msg = account.getMessage(msgnr-1);

        if (msg == null) {
            printErrorMessage("Mensagem não encontrada!");
            return selectMessage(account);
        }

        return msg;
    }

    private static void readMessage(Account account, Message msg) {        
        if (msg == null) { return; }
        System.out.println(msg.toString());
        printNewLine();
        messageMenu(account, msg);
    }

    private static void messageMenu(Account account, Message msg) {
        askInput("[A]nterior   [P]róxima   [L]istar   [E]liminar\n> ");
        char oper = input.nextLine().toLowerCase().charAt(0);

        switch(oper) {
            case 'a':
                readMessage(account, account.readPrevious());
                break;

            case 'p':
                readMessage(account, account.readNext());
                break;

            case 'e':
                account.delete();
                /* break intencionalmente omitido */

            case 'l':
                break;

            default:
                printErrorMessage("Opção inválida!");
                messageMenu(account, msg);
        }
    }


    /*
     * Helper methods
     */
    private static void printStatusMessage(String msg) {
        System.out.flush();
        System.out.println(msg);
        System.out.println();
    }

    private static void printErrorMessage(String msg) {
        System.out.flush();
        System.err.println(msg);
        System.err.println();
        System.err.flush();
    }

    private static void askInput(String msg) {
        System.out.print(msg);
    }

    private static short getOption() {
        short option = input.nextShort();
        if (input.hasNextLine()) {
            input.nextLine();
        }
        printNewLine();
        return option;
    }

    private static void printNewLine() {
        System.out.println();
    }

}
