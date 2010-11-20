
package Ficha5;

import java.util.Random;

/**
 *
 * @author heldercorreia
 */
public class Ex08 {

    private static int[][] board = {
        {-5, -5, -5, -5, -5, -5},
        {-5,  5,  5,  5,  5, -5},
        {-5,  5, 10, 10,  5, -5},
        {-5,  5, 10, 10,  5, -5},
        {-5,  5,  5,  5,  5, -5},
        {-5, -5, -5, -5, -5, -5}
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int points = 0;
        int[] dartThrow;
        for (int t = 1; t <= 5; t++) {
            dartThrow = throwDart();
            printBoard(dartThrow[0], dartThrow[1]);
            points += board[dartThrow[0]][dartThrow[1]];
            System.out.println();
        }

        System.out.println("\nPontos: " + points);
    }

    private static void printBoard(int targetX, int targetY) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == targetX && j == targetY)
                    System.out.print("  X");
                else
                    System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] throwDart() {
        int[] pos = new int[2];
        Random rand = new Random();
        pos[0] = rand.nextInt(6);
        pos[1] = rand.nextInt(6);
        return pos;
    }
}
