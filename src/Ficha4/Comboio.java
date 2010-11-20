
package Ficha4;

/**
 *
 * @author heldercorreia
 */
public class Comboio {

    private int numero;
    private String hora_partida;
    private int linha;
    private String destino;

    public Comboio() {

    }

    public Comboio(int numero, String hora_partida, int linha, String destino) {
        this.numero = numero;
        this.hora_partida = hora_partida;
        this.linha = linha;
        this.destino = destino;
    }

    public void setNumero(int numero) {
        if (numero > 0 && numero < 256) {
            this.numero = numero;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setHoraPartida(String hora_partida) {
        this.hora_partida = hora_partida;
    }

    public String getHoraPartida() {
        return hora_partida;
    }

    public void setLinha(int linha) {
        if (linha >= 1 && linha <= 10) {
            this.linha = linha;
        }
    }

    public int getLinha() {
        return linha;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public boolean partida(String hora) {
        return hora_partida.equals(hora);
    }
}
