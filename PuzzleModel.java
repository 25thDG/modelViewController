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

    // Random int generator for the Game
    static List<Integer> randomIntegers() {
        List<Integer> rndomIntegers = new ArrayList<>();
        Random r = new Random();
        int i = 0;
        int nextInt = 1;
        while (i != 16) {
            nextInt = r.nextInt(0, 16);
            if (!rndomIntegers.contains(nextInt)) {
                rndomIntegers.add(nextInt);
                i++;
            }
        }
        return rndomIntegers;
    }

    public void fillPlayground() {
        int index = 0;
        List<Integer> randomIntegers = randomIntegers();
        for (int row = 0; row < playground.length; row++) {
            for (int column = 0; column < playground.length; column++) {
                playground[row][column] = randomIntegers.get(index++);
                if (playground[row][column] == 0) {
                    emptyRow = row;
                    emptyColumn = column;
                }
            }
        }
    }
    public void randomSwapTiles() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++)
        swapTiles(r.nextInt(0,4), r.nextInt(0,4));
    }

    public int[][] getPlayground() {
        return playground;
    }

    public int getEmptyColumn() {
        return emptyColumn;
    }

    public int getEmptyRow() {
        return emptyRow;
    }

    public static boolean pieceInRightPosition(int row, int column, int[][] playground) {
        if (row == playground.length - 1 && column == playground.length - 1) {
            return playground[row][column] == 0;
        } else {
            int correctValue = row * playground.length + column + 1;
            return playground[row][column] == correctValue;
        }
    }

    private void fillPlaygroundCorrect() {
        int number = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (number <= 15) {
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
}