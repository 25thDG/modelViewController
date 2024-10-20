import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class PuzzleView extends JFrame {

    JButton[][] buttons;
    private JPanel playgroundPanel;
    private final Font FONT;


    public PuzzleView(int BORDER) {
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
                //button.setText("2");
                buttons[i][j] = button;
                playgroundPanel.add(button);
            }
        }

        add(playgroundPanel);

    }
    

    public void updateView(PuzzleModel model) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (model.getPlayground()[i][j] == 0) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(String.valueOf(model.getPlayground()[i][j]));
                    buttons[i][j].setForeground(Color.MAGENTA);
                    if (model.pieceInRightPosition(i, j)) {
                        buttons[i][j].setForeground(Color.GREEN);
                    }
                }
            }
        }
    }

    
    
}
