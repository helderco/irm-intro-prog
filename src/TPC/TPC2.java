
package TPC;

/**
 * Exercícios de operações sobre tabelas de números inteiros
 *
 * @version  09/11/2010
 * @author   20102556 aka Helder Correia
 */
public class TPC2 {

    /*
     * Verifica se um dado número inteiro pertence a uma tabela
     */
    public static boolean find(int needle, int[] haystack) {
        return indexOf(needle, haystack) >= 0;
    }

    /*
     * Retorna a posição de um dado número na tabela (-1 se não encontrado)
     */
    public static int indexOf(int needle, int[] haystack) {
        for (int i = 0; i < haystack.length; i++)
            if (haystack[i] == needle)
                return i;

        return -1;
    }

    /*
     * Retorna o número máximo da tabela
     */
    public static int max(int[] a) {
        int i, max = a[0];
        for (i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    /*
     * Retorna o número mínimo da tabela
     */
    public static int min(int[] a) {
        int i, min = a[0];
        for (i = 1; i < a.length; i++)
            if (a[i] < min)
                min = a[i];

        return min;
    }

    /*
     * Retorna a soma dos números da tabela
     */
    public static int sum(int[] a) {
        int i, sum = 0;
        for (i = 0; i < a.length; i++)
            sum += a[i];

        return sum;
    }

    /*
     * Retorna o produto dos números da tabela
     */
    public static int prod(int[] a) {
        int i, prod = 1;
        for (i = 0; i < a.length; i++)
            prod *= a[i];

        return prod;
    }

    /*
     * Retorna a média dos números da tabela
     */
    public static double avg(int[] a) {
        return (double) sum(a) / a.length;
    }


    /*
     * Retorna a moda dos números da tabela
     * 
     * Solução com dados primitivos. Aceita inteiros negativos.
     * 
     * Nota: É mais eficiente usar a framework de colecções do Java (JCF).
     */
    public static int[] mode(int[] a) {

        int count, max = 1, modeCount = 0;

        int[] frequency = new int[a.length];
        int[] temporary = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int j = 0; j < a.length; j++)
                if (a[i] == a[j])
                    count++;

            if (count > max)
                max = count;

            frequency[i] = count;
        }

        if (max == 1)
            return new int[0];

        for (int i = 0; i < frequency.length; i++)
            if (frequency[i] == max && !find(a[i], temporary))
                temporary[modeCount++] = a[i];

        int[] result = new int[modeCount];
        System.arraycopy(temporary, 0, result, 0, modeCount);

        return result;
    }


    /** Retornar a variância dos números da tabela */
    public static double var(int[] a) {
        double sum = 0.0, avg = avg(a);
        double[] dev = new double[a.length];

        for (int i = 0; i < a.length; i++)
            sum += dev[i] = Math.pow(a[i] - avg, 2);

        return sum / dev.length;
    }
}