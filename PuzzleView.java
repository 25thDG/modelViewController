import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.BorderLayout;
public class PuzzleView extends JFrame{
    private static final Font FONT = new Font("Eurostile", Font.BOLD,28);
 

    private List<JButton> buttons = new LinkedList<>();

    public PuzzleView() {
        //name of the window
        super("Puzzle");
        this.setSize(350,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel pieces = new JPanel(new GridLayout(4,4,7,7));
        for (char c : "abcdefghijklmnop".toUpperCase().toCharArray()) {
            JButton button = new JButton(c + "");
            button.setFont(FONT);
            buttons.add(button);
            pieces.add(button);
        }
        this.add(pieces,BorderLayout.CENTER);
    }
    public List<JButton> geButtons() {return buttons;}

    //public void show(Puzzle puzzle) {
    //}
}
