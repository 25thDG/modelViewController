import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuzzleModel {

    private int[][] playground;
    private int emptyColumn;
    private int emptyRow;

    public PuzzleModel(int BORDER) {
        playground = new int[BORDER][BORDER];
        fillPlaygroundCorrect();
        randomSwapTiles();

    }

    public void swapTiles(int row, int column) {
        if (Math.abs(emptyRow - row) + Math.abs(emptyColumn - column) == 1) {
            playground[emptyRow][emptyColumn] = playground[row][column];
            playground[row][column] = 0;
            emptyRow = row;
            emptyColumn = column;

        }
    }

    

    public int[][] getPlayground() {
        return playground;
    }

   

    public static boolean pieceInRightPosition(int row, int column, int[][] playground) {
        if (row == playground.length - 1 && column == playground.length - 1) {
            return playground[row][column] == 0;
        } else {
            int correctValue = row * playground.length + column + 1;
            return playground[row][column] == correctValue;
        }
    }

    //Before tbe game starts all the pieces are in the right order to ensure that the game is solvable
    private void fillPlaygroundCorrect() {
        int number = 1;
        for (int i = 0; i < playground.length; i++) {
            for (int j = 0; j < playground.length; j++) {
                if (number <= playground.length * playground.length - 1) {
                    playground[i][j] = number;
                    number++;
                } else {
                    playground[i][j] = 0;
                    emptyRow = i;
                    emptyColumn = j;
                }
            }
        }

    }
    //After the field is initialized
    //the pieces are randomly swapped at the beginning.
    public void randomSwapTiles() {
        Random r = new Random();
        for (int i = 0; i < 10000 * playground.length; i++)
            swapTiles(r.nextInt(0, playground.length), r.nextInt(0, playground.length));
    }
}