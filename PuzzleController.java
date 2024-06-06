import javax.swing.*;
public class PuzzleController {
    private Puzzle puzzle;
    private PuzzleView view;

    public PuzzleController(Puzzle puz, PuzzleView viue) {
        this.puzzle = puz;
        this.view = viue;
    }

    public void handleEvents() {
       JButton[][] buttons = view.getButtons();
       for (int row = 0; row < buttons.length; row++) {
        for (int column = 0; column < buttons.length; column++) {
            final int  frow = row;
            final int  fcolumn = column;
            buttons[row][column].addActionListener(ev -> { 
                String label = String.format("X = %d, Y = %d Aktueller Wert = %s", fcolumn, frow
                ,((JButton)ev.getSource()).getText());
                System.out.println(label);
            });
            
        }
    }
    }
}