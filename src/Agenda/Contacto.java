
package Agenda;

import java.io.Serializable;

/**
 *
 * @author Rita
 */
public class Contacto implements Serializable {
    private static int contaNum; //já não começa a 0

    private int numero;
    private String nome;
    //private String morada;
    private int numTel;
    private boolean tipo;
   // private String email;

    public Contacto(String nome, int numTel, boolean tipo) {
        this.numero=++contaNum;
        this.nome = nome;
        this.numTel = numTel;
        this.tipo = tipo;
    }
    //para ler um contacto do ficheiro
    public Contacto(int numero,String nome, int numTel, boolean tipo) {
        this.numero=numero;
        this.nome = nome;
        this.numTel = numTel;
        this.tipo = tipo;
    }
   
    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return numTel;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isMovel() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    //método necessário para poder alterar o número do contacto
     public static void initContaNum(int num) {
        contaNum=num;
    }
    //método para aceder ao número de contacto
    public static int getContaNum() {
        return contaNum;
    }

}



