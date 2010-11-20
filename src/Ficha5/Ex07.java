
package Ficha5;

/**
 *
 * @author heldercorreia
 */
public class Ex07 {

    public static int[][] sum(int[][] A, int[][] B) {

        int rows  = A.length, cols  = A[0].length;
        int bRows = B.length, bCols = B[0].length;

        if (rows != bRows || cols != bCols)
            throw new IllegalArgumentException("Matrices don't match");

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] + B[i][j];

        return result;
    }

    public static int[][] mult(int[][] A, int[][] B) {

        int aRows = A.length, aCols = A[0].length;
        int bRows = B.length, bCols = B[0].length;

        if (aCols != bRows)
            throw new IllegalArgumentException("Matrices don't match");

        int[][] result = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++)
            for (int j = 0; j < bCols; j++)
                for (int k = 0; k < aCols; k++)
                    result[i][j] += A[i][k] * B[k][j];

        return result;
    }

    public static int[][] transp(int[][] A) {

        int rows = A.length, cols = A[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[j][i] = A[i][j];

        return result;
    }
}
