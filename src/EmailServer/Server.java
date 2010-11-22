
package EmailServer;

/**
 * Objecto que representa um servidor email.
 *
 * @author heldercorreia
 */
public class Server {

    /** Lista de contas armazenadas no servidor */
    private Account[] accounts = new Account[1000];

    /** Apontador para o número de contas presentes */
    private int accountPointer = 0;

    /**
     * Regista uma conta no servidor.
     * Não são permitidos endereços já existentes.
     *
     * @see Account
     *
     * @param newAccount  nova conta a ser adicionada
     */
    public void addAccount(Account newAccount) {
        String username = newAccount.getUsername();
        if (fetchAccountFrom(username) != null) {
            throw new IllegalArgumentException(
                "A conta com o utilizador " + username + " já existe."
            );
        }
        accounts[accountPointer++] = newAccount;
    }

    /** Retorna o número de contas existentes */
    public int accountsCount() {
        return accountPointer;
    }

    /**
     * Retorna a conta de uma localização específica na lista.
     * Usado nos testes, para efeitos de comparações.
     *
     * @see ServerTest
     * @see Account
     *
     * @param pos  índice na lista, onde a conta está localizada.
     * @return     objecto Account se pos válido; null caso contrário.
     */
    Account getAccount(int pos) {
        return (pos >= 0 && pos < accountPointer) ? accounts[pos] : null;
    }

    /**
     * Retorna uma conta, usando o endereço de email.
     *
     * @see Account
     * @see getAccount(String, String)
     * @see send(Message)
     *
     * @param username  username (é endereço de email)
     * @return          a conta se encontrada, ou null caso contrário
     */
    private Account fetchAccountFrom(String username) {
        for (int i = 0; i < accountPointer; i++) {
            if (accounts[i].getUsername().equals(username)) {
                return accounts[i];
            }
        }
        return null;
    }

    /**
     * Retorna uma conta, usando credenciais de autenticação.
     * Usado para efeitos de login.
     *
     * @param username  username (é o endereço de email)
     * @param password  password para autenticar
     * @return          a conta se encontrada e autenticada,
     *                  ou null caso contrário
     */
    public Account getAccount(String username, String password) {
        for (int i = 0; i < accountPointer; i++) {
            if (accounts[i].verifyCredentials(username, password)) {
                return accounts[i];
            }
        }
        return null;
    }

    /**
     * Envio de uma mensagem. A mensagem será recebida pelo destinatário.
     *
     * @see Message
     *
     * @param message  mensagem vinda de uma conta existente
     */
    public void send(Message message) {
        Account receiver = fetchAccountFrom(message.getTo());
        if (receiver == null) {
            throw new IllegalArgumentException("Utilizador inexistente.");
        }
        receiver.receive(message);
    }

    /**
     * Elimina uma conta de uma posição específica.
     * Não faz nada, se a posição for inválida.
     *
     * @param pos  a posição da mensagem na inbox
     */
    void delete(int pos) {
        if (pos >= 0 && pos < accountPointer) {
            accounts[pos] = accounts[accountPointer-1];
            accounts[accountPointer--] = null;
        }
    }

    /**
     * Elimina todas as contas inactivas, numa tentativa de poupar espaço.
     */
    public void deleteInnactive() {
        for (int i = 0; i < accountPointer; i++) {
            if (!accounts[i].isActive()) {
                delete(i--);
            }
        }
    }
}
