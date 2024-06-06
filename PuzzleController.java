import java.util.Arrays;

import javax.swing.*;

public class PuzzleController {
    private Puzzle puzzle;
    private PuzzleView view;
    private int lastClickedRow;
    private int lastClickedColumn;
    private String emptyPiece = "X = 3, Y = 3";


    public PuzzleController(Puzzle puz, PuzzleView viue) {
        this.puzzle = puz;
        this.view = viue;
    }

    public void handleEvents() {
        JButton[][] buttons = view.getButtons();
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons.length; column++) {
                final int frow = row;
                final int fcolumn = column;
                buttons[row][column].addActionListener(ev -> {
                    lastClickedColumn = fcolumn;
                    lastClickedRow = frow;
                    if (((JButton) ev.getSource()).getText().equals("")) {
                        emptyPiece = String.format("X = %d, Y = %d", getZ(),getY());
                    }
                    String label = String.format("X = %d, Y = %d Aktueller Wert = %s", getZ(), getY(),
                            ((JButton) ev.getSource()).getText());
                    System.out.println(label);
                });

            }
        }
    }
    public int getY() {
        return lastClickedRow;
    }
    public int getZ() {
        return lastClickedColumn;
    }
    public int getEmptyX() {
        return Integer.parseInt(emptyPiece.replaceAll("\\D", "").substring(0,1));
    }
    public int getEmptyY() {
        return Integer.parseInt(emptyPiece.replaceAll("\\D", "").substring(1));
    }
}