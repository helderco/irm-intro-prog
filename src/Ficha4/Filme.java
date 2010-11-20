
package Ficha4;

/**
 *
 * @author heldercorreia
 */
public class Filme {

    /** Identificação única de cada filme */
    protected int numero;

    /** Duração do filme em minutos */
    protected int duracao;

    /** Valor diário do aluguer do filme */
    protected float aluguerDia;

    /** Indica se o filme está disponível para aluguer ou não */
    protected boolean estado;

    protected String titulo, realizador, actor, genero;

    /*
     * Modificadores
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setAluguerDia(float aluguerDia) {
        this.aluguerDia = aluguerDia;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*
     * Selectores
     */
    public int getNumero() {
        return numero;
    }

    public int getDuracao() {
        return duracao;
    }

    public float getAluguerDia() {
        return aluguerDia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRealizador() {
        return realizador;
    }

    public String getActor() {
        return actor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean getEstado() {
        return estado;
    }

    /*
     * Métodos
     */
    public void aluguerFilme() {
        if (getEstado()) {
            setEstado(false);
        }
        else {
            System.out.println("De momento o filme está alugado!");
        }
    }

    public void devolverFilme(int dias) {
        setEstado(true);
        System.out.printf("Custo: €%.2f\n", dias * getAluguerDia());
    }
}
