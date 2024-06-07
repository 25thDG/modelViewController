import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class PuzzleView extends JFrame {

    JButton[][] buttons;
    final int BORDER = 4;
    private JPanel playgroundPanel;
    private final Font FONT;


    public PuzzleView() {
        super("Puzzle");
        FONT = new Font("Eurostile", Font.BOLD, 30);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    

    
        playgroundPanel = new JPanel(new GridLayout(BORDER,BORDER,7,7));
        playgroundPanel.setSize(650,650);
        buttons = new JButton[BORDER][BORDER];
        for (int i = 0; i < BORDER; i++) {
            for (int j = 0; j < BORDER; j++) {
                JButton button = new JButton();
                button.setFont(FONT);
                button.setText("2");
                buttons[i][j] = button;
                playgroundPanel.add(button);
            }
        }

        add(playgroundPanel);

    }
    

    public void updateView(int[][] playground) {
        for (int i = 0; i < BORDER; i++) {
            for (int j = 0; j < BORDER; j++) {
                if (playground[i][j] == 0) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(String.valueOf(playground[i][j]));
                    buttons[i][j].setForeground(Color.MAGENTA);
                    if (pieceInRightPosition(i, j, playground)) {
                        buttons[i][j].setForeground(Color.GREEN);
                    }
                }
            }
        }
    }

    public boolean pieceInRightPosition(int row, int column, int[][] playground) {
        if (row == BORDER - 1 && column == BORDER - 1) {
            return playground[row][column] == 0;
        } else {
            int correctValue = row * BORDER + column + 1;
            return playground[row][column] == correctValue;
        }
    }
    
}
