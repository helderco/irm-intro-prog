
package Ficha4;

/**
 *
 * @author heldercorreia
 */
public class Conta {

    private static long geraNumero = 1231007001;

    protected long nConta;
    protected String titular;
    protected double saldo;
    protected double plafond;

    Conta(String titular, double saldo, double plafond) {
        this.nConta  = geraNumero++;
        this.titular = titular;
        this.saldo   = saldo;
        this.plafond = plafond;
    }

    public long getNConta() {
        return nConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setPlafond(double plafond) {
        this.plafond = plafond;
    }

    public double saldoContabilistico() {
        return saldo;
    }

    public double saldoDisponivel() {
        return saldo + plafond;
    }

    public void levantamento(double valor) {
        if (saldo + plafond >= valor) {
            saldo -= valor;
        }
    }

    public void deposito(double valor) {
        saldo += valor;
    }
}
