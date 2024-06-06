import javax.swing.JButton;

public class Main {

    public static void main(String[] args) {
        JButton[][] buttons = new JButton[4][4];
        System.out.println(buttons.length);
        PuzzleView game = new PuzzleView();
        game.setVisible(true);
    }
}