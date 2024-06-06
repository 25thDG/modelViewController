import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PuzzleModel {

    private int[][] playground;
    private int emptyColumn;
    private int emptyRow;
    final int BORDER = 4;

    public PuzzleModel() {
        
        playground = new int[BORDER][BORDER];
        fillPlayground();
        

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
        for(int row = 0; row < BORDER; row++) {
            for(int column = 0; column < BORDER; column++) {
                playground[row][column] = randomIntegers.get(index++);
                if (playground[row][column] == 0) {  
                    emptyRow = row;               
                    emptyColumn = column;         
                }
            }
        }
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
    
    


}