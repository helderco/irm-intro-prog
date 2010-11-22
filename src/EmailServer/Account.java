
package EmailServer;

import java.util.Arrays;

/**
 * Objecto que representa uma conta de email.
 *
 * @author heldercorreia
 */
public class Account {

    /** Capacidade da inbox, em número de mensagens */
    static final int INBOX_CAPACITY = 50;

    /** Mínimo de caracteres para o username e password */
    private final int MIN_CHARS = 8;

    /** Endereço de email */
    private String username;

    /** Password para esta conta */
    private String password;

    /** Inbox com as mensagens recebidas */
    private Message[] inbox;

    /** Apontador para o número de mensagens recebidas */
    private int msgPointer  = 0;

    /** Apontador para a última mensagem lida */
    private int readPointer = 0;

    /** Estado da conta (activa ou inactiva) */
    private boolean status;

    /**
     * Construtor da conta.
     *
     * @param username  Username para criação da conta (sem o domínio).
     * @param password  Password para validar login.
     */
    public Account(String username, String password) {
        if (username.length() < MIN_CHARS || password.length() < MIN_CHARS) {
            throw new IllegalArgumentException(
                "Mínimo de " + MIN_CHARS + " caracteres."
            );
        }
        
        this.username = username+"@uac.pt";
        this.password = password;
        this.inbox    = new Message[INBOX_CAPACITY];
        this.status   = true;

        inbox[msgPointer++] = welcomeMessage();
    }

    /**
     * Cada conta criada tem uma primeira mensagem de boas vindas
     * na sua inbox. O método com visibilidade "package private"
     * facilita os testes e remove duplicação.
     *
     * @see AccountTest.testReadFirst()
     * @see Message
     *
     * @return  mensagem de boas vindas
     */
    final Message welcomeMessage() {
        return new Message(
            "servidor@uac.pt", this.username,
            "Bem vindo!",
            "Já está apto a utilizar os nossos novos serviços."
        );
    }

    /** Retorna o username, que é o endereço de email */
    public String getUsername() {
        return username;
    }

    /**
     * Permite a mudança de password.
     *
     * @param oldPassword  password antiga.
     * @param newPassword  password nova para mudar.
     * @return             true se a operação teve sucesso;
     *                     false caso contrário.
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (newPassword.length() < MIN_CHARS) {
            throw new IllegalArgumentException(
                "Mínimo de " + MIN_CHARS + " caracteres"
            );
        }
        if (oldPassword.equals(password)) {
            password = newPassword;
            return true;
        }
        return false;
    }

    /**
     * Autentica a conta, com as credenciais de username e password.
     *
     * @param username  username (endereço de email).
     * @param password  password para autenticar.
     * @return          true se as credenciais são válidas;
     *                  false caso contrário.
     */
    public boolean verifyCredentials(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    /** Verifica se a conta está activa */
    public boolean isActive() {
        return status;
    }

    /**
     * Define o estado da conta: activa ou inactiva.
     *
     * @param status  estado a definir. true para activa; false para inactiva.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Compõe uma nova mensagem, usando o email da conta como remetente.
     *
     * @see Message
     *
     * @param to       o destinatário da mensagem
     * @param subject  o assunto da mensagem
     * @param body     o corpo da mensagem
     * @return         um objecto Message com a nova mensagem
     */
    public Message composeMessage(String to, String subject, String body) {
        return new Message(getUsername(), to, subject, body);
    }

    /**
     * Retorna uma mensagem de uma localização específica na inbox.
     * Usado nos testes, para efeitos de comparações.
     *
     * @see AccountTest
     * @see Message
     *
     * @param pos  índice no inbox, onde a mensagem está localizada.
     * @return     objecto Message se pos válido; null caso contrário.
     */
    Message getMessage(int pos) {
        readPointer = pos;
        return (pos >= 0 && pos < msgPointer) ? inbox[pos] : null;
    }

    /** Retorna o número de mensagens na inbox */
    public int messageCount() {
        return msgPointer;
    }

    /**
     * Recebe uma mensagem na inbox, se houver espaço disponível.
     *
     * @see Message
     *
     * @param message  objecto Message, com a mensagem a receber.
     */
    public void receive(Message message) {
        if (msgPointer == Account.INBOX_CAPACITY) {
            throw new UnsupportedOperationException("Caixa de correio cheia.");
        }
        inbox[msgPointer++] = message;
    }

    /**
     * Retorna a mensagem que está a ser apontada pelo apontador
     * da mensagem a ler.
     *
     * @see readFirst()
     * @see readLast()
     * @see readNext()
     * @see readPrevious()
     * @see Message
     *
     * @return  objecto Message
     */
    public Message read() {
        return inbox[readPointer];
    }

    /**
     * Lê a primeira mensagem na inbox.
     *
     * @see Message
     *
     * @return  objecto Message
     */
    public Message readFirst() {
        readPointer = 0;
        return read();
    }

    /**
     * Lê a última mensagem na inbox.
     *
     * @see Message
     *
     * @return  objecto Message
     */
    public Message readLast() {
        if (msgPointer > 0) {
            readPointer = msgPointer-1;
        }
        return read();
    }

    /**
     * Lê a mensagem anterior à última lida.
     *
     * @see Message
     *
     * @return  objecto Message, ou null caso não haja nenhuma disponível.
     */
    public Message readNext() {
        if (readPointer < inbox.length-1) {
            readPointer++;
            return read();
        }
        return null;
    }

    /**
     * Lê a mensagem seguinte à última lida.
     *
     * @see Message
     *
     * @return  Objecto Message, ou null caso não haja nenhuma disponível
     */
    public Message readPrevious() {
        if (readPointer > 0) {
            readPointer--;
            return read();
        }
        return null;
    }

    /**
     * Elimina uma mensagem de uma posição específica.
     * Não faz nada, se a posição for inválida.
     * Usado nos teste, pois a eliminação de mensagens deve ser feita
     * com todas ao mesmo tempo, ou individualmente após a leitura.
     *
     * @see AccountTest
     * @see delete()
     *
     * @param pos  a posição da mensagem na inbox
     */
    void delete(int pos) {
        if (pos >= 0 && pos < msgPointer) {
            if (pos == msgPointer-1) {
                inbox[pos] = null;
            } else {
                for (int i = pos; i < msgPointer-1; i++) {
                    inbox[i] = inbox[i+1];
                    inbox[i+1] = null;
                }
            }
            msgPointer--;
        }
    }

    /**
     * Elimina a última mensagem lida.
     *
     * @see delete(int)
     */
    public void delete() {
        delete(readPointer--);
    }

    /**
     * Elimina todas as mensagens na inbox.
     */
    public void emptyInbox() {
        while (msgPointer > 0) {
            inbox[--msgPointer] = null;
        }
        readPointer = 0;
    }

    /**
     * Verifica se um objecto é igual a este.
     * Utilizado nos testes, com assertEquals().
     *
     * @see ServerTest
     *
     * @param obj  a referência do objecto para comparar
     * @return     true se este objecto é igual ao argumento obj;
     *             false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inbox, other.inbox)) {
            return false;
        }
        if (this.msgPointer != other.msgPointer) {
            return false;
        }
        return true;
    }

    /**
     * Retorna um código único para este objecto.
     * Deve ser implementado sempre que se faz o override do equals(Object).
     *
     * @see equals(Object)
     *
     * @return  um código único para este objecto
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.username != null ? this.username.hashCode() : 0);
        hash = 59 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 59 * hash + Arrays.deepHashCode(this.inbox);
        hash = 59 * hash + this.msgPointer;
        hash = 59 * hash + this.readPointer;
        hash = 59 * hash + (this.status ? 1 : 0);
        return hash;
    }
    
}
