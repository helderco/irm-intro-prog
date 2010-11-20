
package Ficha5;

/**
 *
 * @author heldercorreia
 */
class Ex09 {

    private int[][] matrix;

    private int[][] copy2d(int[][] src) {
        int[][] copy = new int[src.length][];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = new int[src[i].length];
            System.arraycopy(src[i], 0, copy[i], 0, src[i].length);
        }
        return copy;
    }

    public Ex09(int[][] data) {
        matrix = copy2d(data);
    }

    public int[][] getMatrix() {
        return copy2d(matrix);
    }

    public void switchExtremes() {

        int max, maxIdx, min, minIdx, tmp;
        
        for (int i = 0; i < matrix.length; i++) {
            maxIdx = minIdx = tmp = 0;
            max = min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    maxIdx = j;
                    max = matrix[i][j];
                }
                if (matrix[i][j] < min) {
                    minIdx = j;
                    min = matrix[i][j];
                }
            }
            
            if (maxIdx != minIdx) {
                tmp = matrix[i][maxIdx];
                matrix[i][maxIdx] = matrix[i][minIdx];
                matrix[i][minIdx] = tmp;
            }
        }
    }

    public void shiftColumnsRight() {
        int last;
        for (int i = 0; i < matrix.length; i++) {
            last = matrix[i][matrix[i].length-1];
            for (int j = matrix[i].length-1; j > 0; j--) {
                matrix[i][j] = matrix[i][j-1];
            }
            matrix[i][0] = last;
        }            
    }

    public void shiftLinesUp() {
        int first;
        for (int j = 0; j < matrix[0].length; j++) {
            first = matrix[0][j];
            for (int i = 0; i < matrix.length-1; i++) {
                matrix[i][j] = matrix[i+1][j];
            }
            matrix[matrix.length-1][j] = first;
        }
    }

    public void replaceColumnsByMinimumSum() {
        int sum, minIdx = 0, min = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            sum = 0;

            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }

            if (j == 0 || sum < min) {
                minIdx = j;
                min = sum;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j != minIdx) {
                    matrix[i][j] = matrix[i][minIdx];
                }
            }
        }
    }

    public void sortMatrix() {

        int i;
        int j;
        int[] key;

        for (i = 1; i < matrix.length; i++) {
            key = matrix[i];
            for (j = i-1; (j >= 0) && !isGreaterThan(matrix[j], key); j--) {
                matrix[j+1] = matrix[j];
            }
            matrix[j+1] = key;
        }
    }

    private static boolean isGreaterThan(int[] v1, int[] v2) {
        if (v1.length != v2.length) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < v1.length; i++) {
            if (v1[i] != v2[i]) {
                return v1[i] > v2[i];
            }
        }

        return false;
    }
}
