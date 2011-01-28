
package Ficha6;

/**
 * Exercícios com métodos recursivos
 *
 * Nota: Usos das funções exemplificados nos testes, em Ficha6Test.java
 *
 * @author heldercorreia
 */
public class Ficha6 {

    /** Máximo divisor comum entre dois números */
    public static long mdc(long m, long n) {
        return (n == 0) ? m : mdc(n, m%n);
    }

    /** Função de Ackermann, assumindo que m e n são positivos */
    public static int ackermann(int m, int n) {
        if (m == 0) return 1+n;
        if (n == 0) return ackermann(m-1, 1);
        return ackermann(m-1, ackermann(m, n-1));
    }

    /** Factorial de um número */
    public static int fact(int n) {
        return (n == 1) ? n : n * fact(n-1);
    }

    /** Função seno */
    public static double sen(double x, int n) {
        double term = Math.pow(-1, n) * Math.pow(x, 2*n+1) / fact(2*n+1);
        return n == 0 ? term : term + sen(x, --n);
    }

    /** Número de combinações entre m e n, assumindo que são positivos */
    public static int comb(int m, int n) {
        return (n == 0 || n == m) ? 1 : comb(m-1, n) + comb(m-1, n-1);
    }

    /** Soma dos n primeiros números inteiros não negativos */
    public static int sum(int n) {
        return n == 1 ? n : n + sum(n-1);
    }

    /**
     * Número de zeros num número inteiro
     *
     * @param num    número a usar para pesquisa de zeros
     * @param count  contagem inicial
     * @return       número de zeros encontrados
     */
    public static int zeros(long num, int count) {
        if (num == 0) return count;
        if (num % 10 == 0) count++;
        return zeros(num/10, count);
    }

    /**
     * Mínimo de um vector de inteiros
     *
     * @param v    vector de inteiros
     * @param pos  posição inicial de pesquisa
     * @param min  posição do último mínimo encontrado
     * @return     menor inteiro no vector
     */
    public static int min(int[] v, int pos, int min) {
        if (v[pos] < v[min]) min = pos;
        if (pos == v.length-1) return v[min];
        return min(v, ++pos, min);
    }
}
