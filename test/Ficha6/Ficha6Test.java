
package Ficha6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes para os exercícios de recursividade.
 *
 * Reparar em: assertEquals([valor experado], [valor actual]);
 * O uso dos métodos é exemplificado nos argumentos para [valor actual].
 *
 * @author heldercorreia
 */
public class Ficha6Test {

    /** Precisamos de uma precisão ao comparar doubles */
    private double precision = 1e-6;

    @Test
    public void testMdc() {
        assertEquals(5, Ficha6.mdc(25, 45));
    }

    @Test
    public void testAckermann() {
        assertEquals(4, Ficha6.ackermann(1, 2));
    }

    @Test
    public void testFact() {
        assertEquals(720, Ficha6.fact(6));
    }

    @Test
    public void testSen() {
        assertEquals(0.479425, Ficha6.sen(0.5, 6), precision);
    }

    @Test
    public void testComb() {
        assertEquals(20, Ficha6.comb(6, 3));
    }

    @Test
    public void testSum() {
        assertEquals(21, Ficha6.sum(6));
    }

    @Test
    public void testZeros() {
        assertEquals(6, Ficha6.zeros(100203004953604L, 0));
    }

    @Test
    public void testMin() {
        assertEquals(-6, Ficha6.min(new int[] {5, 4, 40, 3, -6, 0}, 1, 0));
    }
}