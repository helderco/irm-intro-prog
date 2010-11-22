
package EmailServer;

/**
 * Objecto que representa uma mensagem de email.
 *
 * @author heldercorreia
 */
public class Message {

    /** O recipiente */
    private String from;

    /** O destinatário */
    private String to;

    /** O assunto da mensagem */
    private String subject;

    /** O corpo da mensagem */
    private String body;

    /**
     * Construtor
     *
     * @param from     o remetente
     * @param to       o destinatário
     * @param subject  o assunto
     * @param body     o corpo
     */
    public Message(String from, String to, String subject, String body) {
        this.from    = from;
        this.to      = to;
        this.subject = subject;
        this.body    = body;
    }

    /** Retorna o remetente passado ao construtor */
    public String getFrom() {
        return from;
    }

    /** Retorna o destinatário passado ao construtor */
    public String getTo() {
        return to;
    }

    /** Retorna o assunto passado ao construtor */
    public String getSubject() {
        return subject;
    }

    /** Retorna o corpo passado ao construtor */
    public String getBody() {
        return body;
    }

    /** Retorna o cabeçalho para a listagem de mensagens */
    public static String listHeader() {
        return String.format(" Nr. %-20s Assunto", "Remetente");
    }

    /**
     * Sumário representante de uma mensagem, para ser usado como
     * entrada numa lista de mensagens.
     *
     * @param msgnr  número da mensagem, como parte de uma lista
     * @return       sumário com remetente e assunto, para formar
     *               um elemento da list
     */
    public String toHeaderString(int msgnr) {
        return String.format("%3d. %-20s %s", msgnr, from, subject);
    }

    /**
     * Leitura de uma mensagem de email. 
     *
     * @return  o conteúdo da mensagem.
     */
    @Override
    public String toString() {
        return "\nRemetente: " + from
             + "\nDestinatário: " + to
             + "\nAssunto: " + subject
             + "\nMensagem: " + body
             + "\n";
    }

    /**
     * Verifica se um objecto é igual a este.
     * Utilizado nos testes, com assertEquals().
     *
     * @see AccountTest
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
        final Message other = (Message) obj;
        if ((this.from == null) ? (other.from != null) : !this.from.equals(other.from)) {
            return false;
        }
        if ((this.to == null) ? (other.to != null) : !this.to.equals(other.to)) {
            return false;
        }
        if ((this.subject == null) ? (other.subject != null) : !this.subject.equals(other.subject)) {
            return false;
        }
        if ((this.body == null) ? (other.body != null) : !this.body.equals(other.body)) {
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
        hash = 29 * hash + (this.from != null ? this.from.hashCode() : 0);
        hash = 29 * hash + (this.to != null ? this.to.hashCode() : 0);
        hash = 29 * hash + (this.subject != null ? this.subject.hashCode() : 0);
        hash = 29 * hash + (this.body != null ? this.body.hashCode() : 0);
        return hash;
    }

}
