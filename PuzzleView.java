import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.BorderLayout;
public class PuzzleView extends JFrame{
    private static final Font FONT = new Font("Eurostile", Font.BOLD,28);
 

    private JButton[][] buttons = new JButton[4][4];

    //Random int generator for the Game
    private List<Integer> randomIntegers() {
        List<Integer> rndomIntegers = new ArrayList<>();
        Random r = new Random();
        int i = 0;
        int nextInt = 1;
        while (i != 15) {
            nextInt = r.nextInt(1,16);
            if (!rndomIntegers.contains(nextInt)) {
                rndomIntegers.add(nextInt);
                i++;
            }
        }
        return rndomIntegers;
    }

    public PuzzleView() {
        //name of the window
        super("Puzzle");
        this.setSize(350,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel pieces = new JPanel(new GridLayout(4,4,7,7));
        int elementsInPieces = 0;
        List<Integer> randomNumbers = randomIntegers();
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons.length; column++) {
                buttons[row][column] = new JButton();
                //check if 15 numbers are in already if so create the empty piece
                if (elementsInPieces < randomNumbers.size()) {
                    buttons[row][column].setText(String.valueOf(randomNumbers.get(elementsInPieces)));
                    pieces.add(buttons[row][column]);
                    elementsInPieces++;
                } else {
                    buttons[row][column].setText("");
                    pieces.add(buttons[row][column]);
                }
            }
        }
        
        this.add(pieces,BorderLayout.CENTER);
    }
    public JButton[][] geButtons() {return buttons;}

    //public void show(Puzzle puzzle) {
    //}
}
